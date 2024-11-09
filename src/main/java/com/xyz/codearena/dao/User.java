package com.xyz.codearena.dao;

import lombok.Data;
import org.springframework.stereotype.Repository;

/* @Data - lombok 在编译的时候自动将getter setter toString等方法导入进去 */
@Repository
@Data
public class User {
    private String username;
    private String password;
    private boolean enable;
    private boolean locked;


}
