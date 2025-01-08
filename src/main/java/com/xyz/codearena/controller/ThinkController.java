package com.xyz.codearena.controller;

import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.xyz.codearena.dao.JobPageParam;
import com.xyz.codearena.dao.QuestionParam;
import com.xyz.codearena.service.impl.ThinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ThinkController {
    @Autowired
    private final ThinkServiceImpl thinkServiceImpl;

    public ThinkController(ThinkServiceImpl thinkServiceImpl, ParameterNamesModule parameterNamesModule) {
        this.thinkServiceImpl = thinkServiceImpl;
    }

    @RequestMapping(value = "/think/query/page/questions", method = RequestMethod.POST)
    public Map<String, Object> queryQuestionByPage(@RequestBody QuestionParam param){
        System.out.println("url:/think/query/page/questions method:post");
        System.out.println(param);
        return thinkServiceImpl.getQuestionPageByLMC(param);
    }

    @RequestMapping(value = "/think/query/questions", method = RequestMethod.GET)
    public Map<String, Object> queryByLMC(@RequestParam(required = true, value = "LMC") String LMC) {
        System.out.println("url:/think/query/questions method:get");
        System.out.println(LMC);
        return thinkServiceImpl.getQuestionByLMC(LMC);
    }

    @RequestMapping(value = "/think/jobs/query", method = RequestMethod.POST)
    public Map<String, Object> queryJobsByPage(@RequestBody JobPageParam param){
        System.out.println("url:/think/jobs/query method:post");
        System.out.println(param);
        param.setOffset((param.getCurrentPage() - 1) * param.getPageSize());

        return thinkServiceImpl.getJobsByPage(param);
    }

    @RequestMapping(value = "/think/delete/questions", method = RequestMethod.POST)
    public Map<String, Object> deleteQuestion(@RequestBody Integer param){
        System.out.println("url:/think/delete/questions method:post");
        System.out.println(param);

        return thinkServiceImpl.getDeleteQuestionResult(param);
    }

    @RequestMapping(value = "/thinkhome/jobs/delete", method = RequestMethod.POST)
    public Map<String, Object> deleteJob(@RequestBody Integer param){
        System.out.println("url:/think/home/jobs method:post");
        System.out.println(param);

        return thinkServiceImpl.getDeleteJobResult(param);
    }

}
