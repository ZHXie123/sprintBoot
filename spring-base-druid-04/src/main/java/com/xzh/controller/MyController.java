package com.xzh.controller;

import com.xzh.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class MyController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("hello")
    @ResponseBody
    public String sayHello(){
        return "hello fuck you";
    }

    @GetMapping("/getUser")
    @ResponseBody
    public User getUser(){
        String sql = "select * from user where id = ? ; ";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        log.info("查询的user数据为:{}",user.toString());
        return user;
    }
}
