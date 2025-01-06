package com.xyz.codearena.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class QuestionParam {
    @JsonProperty("LMC")
    private String LMC;

    private Integer currentPage;
    private Integer pageSize;
    private Integer offset;

}
