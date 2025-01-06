package com.xyz.codearena.controller;

import com.xyz.codearena.mapper.TestMapper;
import com.xyz.codearena.service.impl.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


// Java 对象 <=> JSON <=> JS

@RestController
public class ManagerController {
    @Autowired
    TestMapper testMapper;
    @Autowired
    ManagerServiceImpl managerServiceImpl;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Map<String, Object> hello() {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "test access hahahaha");
        return res;
    }

    @RequestMapping(value = "/think/options", method = RequestMethod.GET)
    public Map<String, Object> thinkInit() {
        return managerServiceImpl.queryOptions();
    }
}
