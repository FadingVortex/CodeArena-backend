package com.xyz.codearena.mapper;

import com.xyz.codearena.dao.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ThinkMapper {
    List<Question> selectQuestionByLMC(String LMC);
    List<Question> selectQuestionById(@Param("id") Integer id);
    List<TableProps> selectTableProps(String tableName);
    Integer selectQuestionCount(@Param("param") QuestionParam param);

    // 将param映射成@Param("param")后，再在数据库中使用 MyBait注解
    // 如果只有一个参数，MyBatis 会自动将其中的成员取出进行映射，在sql中直接使用不用加上param.前缀
    // 但是如果加上了注解，那么相当于只传送了一个参数，就需要使用param.前缀
    List<Question> selectQuestionByPage(@Param("param") QuestionParam param);

    List<Job> selectJobsByPage(@Param("param") JobPageParam param);
    Integer countJobs(@Param("param") JobPageParam param);

    void deleteQuestion(@Param("id") Integer id);
    void deleteJobsById(@Param("id") Integer id);
    void deleteJob(@Param("runid") Integer runid);


}
