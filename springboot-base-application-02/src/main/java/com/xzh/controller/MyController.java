package com.xzh.controller;

import com.xzh.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyController {

    @Autowired
    private User user;

    @ResponseBody
    @RequestMapping("nima")
    public String getUserFromYaml(){
        System.out.println(user);
        return "你妈";
    }
}
