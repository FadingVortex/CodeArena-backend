package com.xyz.codearena.service;

import com.xyz.codearena.dao.JobPageParam;
import com.xyz.codearena.dao.QuestionParam;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface ThinkService {
    public Map<String, Object> getQuestionByLMC(String LMC);
    public Map<String, Object> getQuestionPageByLMC(QuestionParam param);
    public Map<String, Object> getJobsByPage(JobPageParam param);

}
