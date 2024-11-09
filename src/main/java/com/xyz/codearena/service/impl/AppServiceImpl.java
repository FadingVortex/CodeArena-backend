package com.xyz.codearena.service.impl;

import com.xyz.codearena.dao.User;
import com.xyz.codearena.service.AppService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AppServiceImpl implements AppService {


    @Override
    public Map<String, Object> login(String username, String password) {
        // 查询数据库，得到对应用户信息，根据用户信息，选择不同结果。
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");

        Map<String, Object> data = new HashMap<>();
        data.put("username", username);
        data.put("password", password + "$#@%$#jflwetpijdsfjldshffldshf&%&%^&%^");

        res.put("data", data);

        return res;
    }
}
