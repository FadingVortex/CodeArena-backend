package com.xyz.codearena.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // 创建Json文件时会自动忽略值为NULL的变量
public class Question {
    @JsonProperty("SNO")
    private String SNO;

    @JsonProperty("LMC") //需要指定转换成JSON对象后对应的键名，否则会自动按照规则转化为全部小写 lmc
    private String LMC;

    @JsonProperty("pdfString")
    private String pdfString;

    private Integer id;
    private String title;
    private Integer pass;
    private Integer submit;
    private String content;

}
