package com.xyz.codearena.service.impl;

import com.xyz.codearena.dao.Option;
import com.xyz.codearena.dao.User;
import com.xyz.codearena.mapper.TestMapper;
import com.xyz.codearena.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    TestMapper testMapper;

    @Override
    public Map<String, Object> queryOptions() {
//        System.out.println("thinkInit");

        List<Option> options = testMapper.selectSelectOption();
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "successfully");
        Map<String, Object> data = new HashMap<>();
        data.put("options", options);

        res.put("data", data);
        return res;
    }
}
