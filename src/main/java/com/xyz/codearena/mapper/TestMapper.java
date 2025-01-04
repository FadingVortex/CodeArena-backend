package com.xyz.codearena.mapper;

import com.xyz.codearena.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestMapper {
    List<User> selectUsernamePassword(@Param("username") String username);
    // 在配置文件中设置对应的sql语句



}
