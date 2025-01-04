package com.xyz.codearena.controller;

import com.xyz.codearena.dao.User;
import com.xyz.codearena.mapper.TestMapper;
import com.xyz.codearena.service.impl.AppServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
public class SecurityController {
//    @Autowired
//    private SecurityService securityService;
//    private AppServiceImpl appServiceImpl;
    @Autowired
    private TestMapper testMapper;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody User user) {
        System.out.println(user);
        Map<String, Object> res = new HashMap<>();
        res.put("code", 200);

        List<User> dbresult = testMapper.selectUsernamePassword(user.getUsername());
        // 用户名判断
        if(dbresult.size() != 1){
            res.put("msg", "Wrong username");
            return res;
        }


        // 判断密码
        User item = (User) dbresult.get(0);
        String userPassword = user.getPassword();
        String itemPassword = item.getPassword();

        if(userPassword.equals(itemPassword)){
            // 是否Locked，是否有效
            Map<String, Object> data = new HashMap<>();
            data.put("token", "12234djflsjfldsjfjdfl");
            data.put("username", user.getUsername());
            res.put("data", data);
            res.put("code", 200);
            return res;
        } else {
            res.put("msg", "Wrong password");
            res.put("code", -1);
            return res;
        }

//        if(item.getPassword().equals(user.getPassword())){}

//        return appServiceImpl.login(user.getUsername(), user.getPassword());

//        return securityService.checkUserInformation(user);
    }
}
