package com.xyz.codearena.service.impl;

import com.xyz.codearena.dao.Question;
import com.xyz.codearena.mapper.EditMapper;
import com.xyz.codearena.service.EditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EditServiceImpl implements EditService {
    @Autowired
    EditMapper editMapper;

    @Override
    public Map<String, Object> getUpdateResult(Question param) {
        System.out.println("EditService: getUpdateResult");
        Map<String, Object> res = new HashMap<>();
        System.out.println(param.getPdfString() == null ? "null" : "param is not null");

        try {
            editMapper.updateQuestion(param);
            res.put("code", 200);
            res.put("msg", "update success");
        } catch (Exception e) {
            res.put("code", -2);
            res.put("msg", "failure");
        }
        return res;
    }

    @Override
    public Map<String, Object> getInsertResult(Question param) {
        System.out.println("EditService: getInsertResult");
        Map<String, Object> res = new HashMap<>();

        try {
            editMapper.insertQuestion(param);
            res.put("code", 200);
            res.put("msg", "update success");
        } catch (Exception e) {
            res.put("code", -2);
            res.put("msg", "failure");
        }
        return res;
    }
}
