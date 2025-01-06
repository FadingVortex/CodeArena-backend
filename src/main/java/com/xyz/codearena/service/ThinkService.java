package com.xyz.codearena.service;

import org.springframework.stereotype.Service;

import java.util.Map;

public interface ThinkService {
    public Map<String, Object> getQuestionByLMC(String LMC);

}
