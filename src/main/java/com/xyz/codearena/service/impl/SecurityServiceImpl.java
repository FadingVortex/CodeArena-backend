package com.xyz.codearena.service.impl;

import com.xyz.codearena.dao.User;
import com.xyz.codearena.mapper.TestMapper;
import com.xyz.codearena.service.SecurityService;
import com.xyz.codearena.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    TestMapper testMapper;

    @Override
    public Map<String, Object> login(User user) {
        // 查询数据库，得到对应用户信息，根据用户信息，选择不同结果。
        System.out.println(user);
        Map<String, Object> res = new HashMap<>();

        List<User> result = testMapper.selectByUser(user);
        // 用户名判断
        if(result.size() != 1){
            res.put("msg", "Wrong username");
            res.put("code", 400);
            return res;
        }

        // 判断密码
        User item = (User) result.get(0);
        String userPassword = user.getPassword();
        String itemPassword = item.getPassword();

        if(userPassword.equals(itemPassword)){
            // 是否Locked，是否有效
            Map<String, Object> data = new HashMap<>();
            String token = JwtUtil.createJwt(user.getUsername(), user.getPassword());
            System.out.println("generate JWT:" + token);
            System.out.println("decode JWT:" + JwtUtil.parseJWT(token));
            data.put("token", token);
            data.put("username", user.getUsername());
            res.put("data", data);
            res.put("code", 200);
            res.put("msg", "success");
            return res;
        } else {
            res.put("msg", "Wrong password");
            res.put("code", -1);
            return res;
        }
    }

}
