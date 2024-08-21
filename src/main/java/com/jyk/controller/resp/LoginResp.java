package com.jyk.controller.resp;

import com.google.gson.Gson;

/**
 * @author : Jing Yuankui
 * @description : 登录返回类
 * @date : Created in 2024/8/13 23:51
 */
public class LoginResp {

    /**
     * 登录态，token
     */
    private String token;

    private Integer userId;

    private String userName;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        Gson g = new Gson();
        return g.toJson(this);
    }
}
