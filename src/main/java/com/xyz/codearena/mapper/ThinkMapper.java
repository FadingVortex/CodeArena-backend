package com.xyz.codearena.mapper;

import com.xyz.codearena.dao.Question;
import com.xyz.codearena.dao.TableProps;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThinkMapper {
    List<Question> selectQuestionByLMC(String LMC);
    List<TableProps> selectTableProps(String tableName);
}
