package com.jyk.controller.resp;

import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 景元奎的返回对象
 * @date : Created in 2024/7/25 23:36
 */
public class JYKResp {
    private String name;
    private Integer age;
    private String sex;
    private String career;
    private List<String> hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }
}
