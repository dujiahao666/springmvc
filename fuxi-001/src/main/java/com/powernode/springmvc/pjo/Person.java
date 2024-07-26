package com.powernode.springmvc.pjo;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/11 1:32
 * @description:
 */
public class Person {
   private String username;
   private Integer password;

    public Person() {
    }

    public Person(String username, Integer password) {
        this.username = username;
        this.password = password;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public Integer getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(Integer password) {
        this.password = password;
    }

    public String toString() {
        return "Person{username = " + username + ", password = " + password + "}";
    }
}
