package com.powernode.springmvc.controller;

import com.powernode.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/25 13:28
 * @description:
 */
@Controller
public class UserController {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAll(){
        System.out.println("正在查询所有用户信息...");
        return "ok";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getById(@PathVariable("id") String id){
        System.out.println("已经查询到了账户为"+id+"的信息");
        return "ok";
    }

    @PostMapping(value = "/user")
    public String save(User user){
        System.out.println("正在保存用户信息...,用户的信息是："+user);
        return "ok";
    }

    @PutMapping(value = "/user")
    public String modify(User user){
        System.out.println("正在修改用户信息...,用户的信息是："+user);
        return "ok";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String id){
        System.out.println("正在删除用户id为："+id+"的用户信息");
        return "ok";
    }
}
