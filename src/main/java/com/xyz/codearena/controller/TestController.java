package com.xyz.codearena.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


// Java 对象 <=> JSON <=> JS

@RestController
public class TestController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Map<String, Object> hello() {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "test access hahahaha");
        return res;
    }

}
