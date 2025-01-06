package com.xyz.codearena.service;

import com.xyz.codearena.dao.User;

import java.util.Map;

public interface SecurityService {
    Map<String, Object> login(User user);

}
