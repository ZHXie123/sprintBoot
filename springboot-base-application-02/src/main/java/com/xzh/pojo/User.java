package com.xzh.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "xzh.user")
public class User {


    private String username;


    private String password;


    private List<String> gfs;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getGfs() {
        return gfs;
    }

    public void setGfs(List<String> gfs) {
        this.gfs = gfs;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gfs=" + gfs +
                '}';
    }
}
