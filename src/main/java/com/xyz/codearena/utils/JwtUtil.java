package com.xyz.codearena.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtil {

    // 目前 6s
    public static final long JWT_TTL = 1000 * 600 ;  // 有效期14天
    public static final String JWT_KEY = "JSDFSDFSDFASJDHASDASDdfa32dJHASFDA67765asda123";//密钥
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    //Base64编码密钥
    public static SecretKey generalKey() {
        byte[] encodeKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        return new SecretKeySpec(encodeKey, 0, encodeKey.length, "HmacSHA256");
    }

    // 生成 JWT Token
    public static String createJwt(String username,String role) {
        //密钥
        SecretKey secretKey = generalKey();

        //开始时间（被签发的时间）
        long nowMillis = System.currentTimeMillis();
        //持续时间
        Long ttlMillis = JwtUtil.JWT_TTL;
        //失效时间（过期时间）
        long expMillis = nowMillis + ttlMillis;

        //开始日期类型，转换类型
        Date now = new Date(nowMillis);
        //失效日期类型，转换类型
        Date expDate = new Date(expMillis);


        return Jwts.builder()
                .setId(getUUID())           //随机生成一个ID
                .setSubject(username)       //设置sub（主题）声明，即针对的用户
                .setIssuer("se")            //签发者，随便写就可以
                .setIssuedAt(now)           //token开始时间
                .setExpiration(expDate)     //token失效时间
                .claim("role", role)  //将角色添加到 Payload 中
                .signWith(SignatureAlgorithm.HS256, secretKey) //使用HS256编码格式，以及密钥进行加密
                .compact();                 //将各部分进行编码和组合
    }

    // 解析 JWT Token
    public static Claims parseJWT(String jwt)  {
        //密钥
        SecretKey secretKey = generalKey();
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    //从JWT令牌中提取过期时间
    private Date extractExpiration(String token) {
        //密钥
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)  // 使用密钥验证JWT的签名
                .parseClaimsJws(token)  // 解析JWT
                .getBody()  // 获取JWT的主体部分
                .getExpiration();  // 返回JWT的过期时间
    }

    //检查JWT是否已经过期
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


    //从JWT令牌中提取出用户名
    public String extractUsername(String token) {
        //密钥
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)  // 设置密钥进行验证
                .parseClaimsJws(token)  // 解析JWT
                .getBody()  // 获取JWT的主体部分
                .getSubject();  // 返回主体部分中的“subject”（用户名）
    }

    //验证JWT是否有效
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);  // 提取JWT中的用户名
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));  // 判断用户名是否一致且令牌没有过期
    }


}
