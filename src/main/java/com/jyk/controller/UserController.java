package com.jyk.controller;

import com.jyk.controller.resp.JYKResp;
import com.jyk.dao.User;
import com.jyk.service.UserService;
import com.jyk.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : UserController
 * @date : Created in 2024/7/27 20:33
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/search-all")
    public List<User> searchAllUser(String str) {
        return userService.selectAllUser();
    }

    @PostMapping("/add-user")
    public Integer addOneUser(String str) {
        User user1 = new User();
        Date date = new Date();
        user1.setName("景元奎");
        user1.setAge(28);
        user1.setEmail("773669388@qq.com");
        user1.setCreateBy("jyk");
        user1.setCreateTime(date);
        user1.setUpdateBy("jyk");
        user1.setUpdateTime(date);
        return userService.insertUser(user1);
    }

    @PostMapping("/login")
    public ResponseVo<Boolean> login(@RequestBody User user) {

        return userService.login(user);
    }


}
