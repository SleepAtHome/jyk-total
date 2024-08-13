package com.jyk.service;

import com.jyk.controller.resp.LoginResp;
import com.jyk.dao.User;
import com.jyk.vo.ResponseVo;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 用户Service
 * @date : Created in 2024/7/27 20:35
 */
public interface UserService {

    List<User> selectAllUser();
    int insertUser(User user);
    ResponseVo<LoginResp> login(User user);
    /*User getUserById(Integer id);
    int updateUser(User user);
    int deleteUser(Integer id);*/
}
