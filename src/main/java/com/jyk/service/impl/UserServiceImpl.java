package com.jyk.service.impl;

import com.jyk.dao.User;
import com.jyk.enums.ResponseEnum;
import com.jyk.mapper.UserMapper;
import com.jyk.service.UserService;
import com.jyk.utils.RsaUtils;
import com.jyk.vo.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

/**
 * @author : Jing Yuankui
 * @description : 用户Service
 * @date : Created in 2024/7/27 20:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Value("${rsa.private.key}")
    String privateKey;

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
        // 判断入参
        if (null==user || StringUtils.isEmpty(user.getAccount()) || StringUtils.isEmpty(user.getPassword())) {
            System.out.println("登录失败，账号或密码为空");
            return ResponseVo.error(ResponseEnum.LOGIN_ERROR);
        }

        String inputAccount = user.getAccount();
        // RSA私钥解密
        String inputPassword = null;
        try {
            inputPassword = RsaUtils.decryptByPrivateKey(privateKey, user.getPassword());
        } catch (Exception e) {
            System.out.println("解密密码失败！");
            e.printStackTrace();
            //throw new RuntimeException(e);
            return ResponseVo.error(ResponseEnum.LOGIN_ERROR);
        }


        // 查询用户数据
        User dataU = userMapper.selectUserByAccount(inputAccount);

        // 如果查不到用户，或者密码错误
        if (Objects.isNull(dataU) || !inputPassword.equals(dataU.getPassword())) {
            return ResponseVo.error(ResponseEnum.LOGIN_ERROR);
        }

        /* 登录态
        String token = TokenUtil.generateToken(user.getUsername());
        UserInfo userInfo = new UserInfo();
        userInfo.setId(one.getId());
        userInfo.setUsername(user.getUsername());
        userInfo.setToken(token);
        String sessionId = TokenUtil.storeTokenInSession(request, token);
        userInfo.setSessionId(sessionId);
        return R.ok(userInfo);*/


        return ResponseVo.success(true);
    }
}
