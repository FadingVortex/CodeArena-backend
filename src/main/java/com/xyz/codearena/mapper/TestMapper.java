package com.xyz.codearena.mapper;

import com.xyz.codearena.dao.Option;
import com.xyz.codearena.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestMapper {
    List<User> selectUsernamePassword(@Param("username") String username);
    List<User> selectByUser(@Param("user") User user);
    List<Option> selectSelectOption();
    // 在配置文件中设置对应的sql语句



}
