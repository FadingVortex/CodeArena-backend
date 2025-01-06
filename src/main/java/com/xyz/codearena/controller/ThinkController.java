package com.xyz.codearena.controller;

import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.xyz.codearena.dao.QuestionParam;
import com.xyz.codearena.service.impl.ThinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ThinkController {
    private final ThinkServiceImpl thinkServiceImpl;

    public ThinkController(ThinkServiceImpl thinkServiceImpl, ParameterNamesModule parameterNamesModule) {
        this.thinkServiceImpl = thinkServiceImpl;
    }



    @RequestMapping(value = "/think/query/page/questions", method = RequestMethod.POST)
    public Map<String, Object> queryQuestionByPage(@RequestBody QuestionParam param){
        System.out.println(param);
        return thinkServiceImpl.getQuestionPageByLMC(param);
    }

    @RequestMapping(value = "/think/query/questions", method = RequestMethod.GET)
    public Map<String, Object> queryByLMC(@RequestParam(required = true, value = "LMC") String LMC) {
        System.out.println("queryByLMC" + LMC);
        System.out.println(thinkServiceImpl.getQuestionByLMC(LMC));
        return thinkServiceImpl.getQuestionByLMC(LMC);
    }
}
