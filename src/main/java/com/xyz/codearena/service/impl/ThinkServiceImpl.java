package com.xyz.codearena.service.impl;

import com.xyz.codearena.dao.Question;
import com.xyz.codearena.dao.QuestionParam;
import com.xyz.codearena.dao.TableProps;
import com.xyz.codearena.mapper.ThinkMapper;
import com.xyz.codearena.service.ThinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        System.out.println("LMC" + param.getLMC());
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
}
