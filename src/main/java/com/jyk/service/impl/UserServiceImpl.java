package com.jyk.service.impl;

import com.jyk.dao.User;
import com.jyk.enums.ResponseEnum;
import com.jyk.mapper.UserMapper;
import com.jyk.service.UserService;
import com.jyk.vo.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    @Override
    public ResponseVo<Boolean> login(User user) {
        String inputAccount = user.getAccount();
        String inputPassword = user.getPassword();

        if (StringUtils.isEmpty(inputAccount) || StringUtils.isEmpty(inputPassword)) {
            System.out.println("登录失败，账号或密码为空");
            return ResponseVo.error(ResponseEnum.LOGIN_ERROR);
        }

        // 查询用户数据
        User dataU = userMapper.selectUserByAccount(inputAccount);

        // 如果查不到用户，或者密码错误
        if (Objects.isNull(dataU) || !inputPassword.equals(dataU.getPassword())) {
            return ResponseVo.error(ResponseEnum.LOGIN_ERROR);
        }

        return ResponseVo.success(true);
    }
}
