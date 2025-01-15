package com.xyz.codearena.config.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz.codearena.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = getJwtFromRequest(request);

        if (StringUtils.hasText(token)) {
            try {
                // 解析JWT
                Claims claims = jwtUtil.parseJWT(token);

                //检查token是否过期
                if (claims != null && !jwtUtil.isTokenExpired(token)) {

                    // 提取用户名
                    String username = claims.getSubject();
                    // 提取角色权限
                    String role = claims.get("role", String.class);
                    // 将角色权限加入 GrantedAuthority 的列表
                    List<GrantedAuthority> authorities = new ArrayList<>();
                    authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
                    // 认证信息
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(username, null, authorities);
                    // 将认证信息存储到SecurityContext中
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

            } catch (ExpiredJwtException e) {
                // 捕获 JWT 过期异常，并返回自定义消息
                sendCustomData(response, 401,"您的Token已过期，请重新登录", 200);
                return;
            }catch (Exception e) {
                // 捕获其他异常，返回自定义消息
                sendCustomData(response, 400,"无效的 Token", 200);
                return;
            }
        }

        //将请求继续传递给后续的过滤器
        //在过滤器链中调用下一个过滤器或请求处理器的关键方法
        filterChain.doFilter(request, response);
    }


    //从 HTTP 请求的 Authorization 头部中提取出 JWT
    private String getJwtFromRequest(HttpServletRequest request) {
        //获取请求头中的 Authorization 字段
        String bearerToken = request.getHeader("Authorization");
        //检查 Authorization 头部是否包含 Bearer 前缀，如果有 Bearer 前缀，去掉它并返回 JWT 字符串；如果没有，返回 null
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    //自定义AckCode返回响应信息
    private void sendCustomData(HttpServletResponse response, int AckCode, String message, int statusCode) throws IOException {
        response.setStatus(statusCode);  // 设置 HTTP 状态码
        response.setContentType("application/json;charset=UTF-8");  // 设置响应内容类型为 JSON 且指定字符编码为 UTF-8
        response.setCharacterEncoding("UTF-8");  // 设置响应编码为 UTF-8

        // 构造自定义数据响应内容
        Map<String, Object> res = new HashMap<>();
        res.put("msg", message);  // 消息提示
        res.put("code", AckCode );  // 返回码

        // 使用 Jackson 将 Map 转换为 JSON 字符串
        String jsonResponse = new ObjectMapper().writeValueAsString(res);

        // 输出响应内容
        response.getWriter().write(jsonResponse);
    }
}