package com.powernode.springmvc.pojo;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/19 3:28
 * @description:
 */
public class User {
    private String a;
    private String b;

    public User() {
    }

    public User(String username, String password) {
        this.a = username;
        this.b = password;
    }

    public String getUsername() {
        return a;
    }

    public void setUsername(String username) {
        this.a = username;
    }

    public String getPassword() {
        return b;
    }

    public void setPassword(String password) {
        this.b = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + a + '\'' +
                ", password='" + b + '\'' +
                '}';
    }
}
