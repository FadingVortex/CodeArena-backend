package com.xyz.codearena.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

/* @Data - lombok 在编译的时候自动将getter setter toString等方法导入进去 */
@Repository
@Data
public class User {
    @JsonIgnore
    private long userid;
    private String username;
    private String password;
    @JsonIgnore
    private boolean enable;
    @JsonIgnore     // JSON JAVA 相互转换时忽略该属性
    private boolean locked;
    private List<Role> roles;

}
