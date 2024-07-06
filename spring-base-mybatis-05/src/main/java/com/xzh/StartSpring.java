package com.xzh;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@MapperScan("com.xzh.mappers")
@SpringBootApplication
public class StartSpring {


    public static void main(String[] args){
        SpringApplication.run(StartSpring.class,args);
    }
}
