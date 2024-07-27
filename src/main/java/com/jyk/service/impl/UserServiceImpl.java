package com.jyk.service.impl;

import com.jyk.dao.User;
import com.jyk.mapper.UserMapper;
import com.jyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 用户Service
 * @date : Created in 2024/7/27 20:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
