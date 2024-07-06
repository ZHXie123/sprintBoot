package com.xzh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("springboot")
public class MyController {

    @Value("${xzh.name}")
    private String name;

    @RequestMapping("hello")
    @ResponseBody
    public String sayHello(){
        System.out.println(name);
        return "hello" + name;
    }
}
