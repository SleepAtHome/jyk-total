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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        Gson g = new Gson();
        return g.toJson(this);
    }
}
