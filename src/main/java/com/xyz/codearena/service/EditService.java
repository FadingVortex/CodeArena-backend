package com.xyz.codearena.service;

import com.xyz.codearena.dao.Question;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface EditService {
    public Map<String, Object> getUpdateResult(Question param);
    public Map<String, Object> getInsertResult(Question param);
}
