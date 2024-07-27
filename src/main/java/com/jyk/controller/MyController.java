package com.jyk.controller;

import com.jyk.controller.resp.JYKResp;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Jing Yuankui
 * @description : 我的Controller
 * @date : Created in 2021/10/19 19:26
 */
@RestController
@RequestMapping("/jyk")
public class MyController {

    @GetMapping("/request/get")
    public JYKResp myFirstRequest(@RequestParam String str) {
        System.out.println("景元奎的一个get请求, 请求参数为:  " + str);
        JYKResp resp = new JYKResp();
        resp.setName("戴君雅");
        resp.setAge(29);
        resp.setSex("female");
        resp.setCareer("前端");

        List<String> list = new ArrayList();
        list.add("读书");
        list.add("学习");
        list.add("玩游戏");

        resp.setHobby(list);
        return resp;
    }

    @PostMapping("/request/post")
    public JYKResp jykRequest(String str) {
        System.out.println("景元奎的一个post请求, 请求参数为:  " + str);
        JYKResp resp = new JYKResp();
        resp.setName("景元奎");
        resp.setAge(28);
        resp.setSex("male");
        resp.setCareer("IT");

        List<String> list = new ArrayList();
        list.add("读书");
        list.add("学习");
        list.add("玩游戏");

        resp.setHobby(list);
        return resp;
    }

}
