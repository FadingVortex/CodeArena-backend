package com.xyz.codearena.controller;

import com.xyz.codearena.dao.User;
import com.xyz.codearena.service.impl.AppServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AppController {
    @Autowired
    private AppServiceImpl appServiceImpl;

    /* 可以将username的value值提取出来赋值为 xx 变量 */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody User user) {
        System.out.println(user);
        return appServiceImpl.login(user.getUsername(), user.getPassword());

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> register() {


        return null;
    }
}
