package com.xyz.codearena.controller;

import com.xyz.codearena.dao.Question;
import com.xyz.codearena.service.impl.EditServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EditController {
    @Autowired
    EditServiceImpl editServiceImpl;


    @RequestMapping(value = "/edit/update/question", method = RequestMethod.POST)
    public Map<String, Object> updateQuestion(@RequestBody Question param){
        System.out.println("url:/edit/update/question method:post");
        System.out.println(param);

        return editServiceImpl.getUpdateResult(param);
    }


    @RequestMapping(value = "/edit/add/question", method = RequestMethod.POST)
    public Map<String, Object> insertQuestion(@RequestBody Question param){
        System.out.println("url:/edit/add/question method:post");
        System.out.println(param);

        return editServiceImpl.getInsertResult(param);
    }
}
