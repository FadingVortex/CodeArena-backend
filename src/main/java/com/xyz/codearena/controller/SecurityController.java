package com.xyz.codearena.controller;

import com.xyz.codearena.dao.User;
import com.xyz.codearena.service.impl.SecurityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;



@RestController
public class SecurityController {
    @Autowired
    private SecurityServiceImpl securityServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody User user) {
        return securityServiceImpl.login(user);
    }
}
