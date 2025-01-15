package com.xyz.codearena.mapper;

import com.xyz.codearena.dao.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EditMapper {

    void updateQuestion(@Param("param") Question param);
    void insertQuestion(@Param("param") Question param);
}
