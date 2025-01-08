package com.xyz.codearena.service.impl;

import com.xyz.codearena.dao.*;
import com.xyz.codearena.mapper.ThinkMapper;
import com.xyz.codearena.service.ThinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class ThinkServiceImpl implements ThinkService {
    @Autowired
    ThinkMapper thinkMapper;

    @Override
    public Map<String, Object> getQuestionByLMC(String LMC) {
        System.out.println("LMC" + LMC);

        Map<String, Object> res = new HashMap<>();

        try {
            res.put("code", 200);
            res.put("msg", "成功返回");

            Map<String, Object> data = new HashMap<>();
            data.put("tableData", thinkMapper.selectQuestionByLMC(LMC));
            data.put("tableProps", thinkMapper.selectTableProps("questions"));
            res.put("data", data);
            System.out.println(data);

        } catch(Exception e) {
            res.put("code", -2);
            res.put("msg", "操作失败");
            return res;
        }
        return res;
    }



    @Override
    public Map<String, Object> getQuestionPageByLMC(QuestionParam param) {
        Integer total = 0;
        param.setOffset((param.getCurrentPage() - 1) * param.getPageSize());

        List<Question> tableData;
        List<TableProps> tableProps;
        Map<String, Object> res = new HashMap<>();

        try {
            tableData = thinkMapper.selectQuestionByPage(param);
            tableProps = thinkMapper.selectTableProps("questions");
            total = thinkMapper.selectQuestionCount(param);
            res.put("code", 200);
            res.put("msg", "成功返回");

            Map<String, Object> data = new HashMap<>();
            data.put("tableData", tableData);
            data.put("tableProps", tableProps);
            data.put("total", total);
            res.put("data", data);

            System.out.println("res: " + res);

        } catch(Exception e) {
            res.put("code", -2);
            res.put("msg", "操作失败");
            e.printStackTrace();
            return res;
        }
        return res;
    }


    @Override
    public Map<String, Object> getJobsByPage(JobPageParam param) {
        System.out.println("ThinkService: getJobsByPage");

        System.out.println(param);

        List<Job> tableData = thinkMapper.selectJobsByPage(param);

        System.out.println(tableData);
        int total = thinkMapper.countJobs(param);
        List<TableProps> tableProps = thinkMapper.selectTableProps("jobs");
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        if(tableData == null || tableProps == null) {
            res.put("code", 201);
            res.put("msg", "failure");
        } else {
            res.put("code", 200);
            res.put("msg", "success");

            data.put("tableData", tableData);
            data.put("tableProp", tableProps);
            data.put("total", total);
            res.put("data", data);
        }
        return res;
    }


    // 事务注解
    @Transactional
    public Map<String, Object> getDeleteQuestionResult(Integer id) {
        System.out.println("ThinkService: getDeleteQuestionResult");
        Map<String, Object> res = new HashMap<>();

        try {
            thinkMapper.deleteJobsById(id);
            thinkMapper.deleteQuestion(id);
            res.put("code", 200);
            res.put("msg", "delete success");
        } catch (Exception e) {
            res.put("code", -2);
            res.put("msg", "failure");
            e.printStackTrace();
        }
        return res;
    }


    public Map<String, Object> getDeleteJobResult(Integer id) {
        System.out.println("ThinkService: getDeleteJobResult");
        Map<String, Object> res = new HashMap<>();

        try {
            thinkMapper.deleteJob(id);
            res.put("code", 200);
            res.put("msg", "delete success");
        } catch (Exception e) {
            res.put("code", -2);
            res.put("msg", "failure");
            e.printStackTrace();
        }
        return res;
    }

}
