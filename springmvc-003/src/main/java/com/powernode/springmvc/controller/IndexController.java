package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/17 11:22
 * @description:
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

//    @RequestMapping(value = {"/testValue1","/testValue2"})
    @RequestMapping(path = {"/testValue1","/testValue2"})
//
    public String testRequestMappingValue(){
        //处理业务逻辑
        //返回逻辑视图
        return "test_value";
    }

    @RequestMapping("/login/{username}/{password}")
    public String testResultFul(
            @PathVariable("username")
            String us,
            @PathVariable(value = "password")
            String ps){
        System.out.println("账户是："+us);
        System.out.println("密码是："+ps);
        return "ok";
    }

    @RequestMapping(value = "/user/login",method ={RequestMethod.POST,RequestMethod.GET})
//    @RequestMapping(value = "/user/login")
//    @PostMapping("/userlogin"
    public String userLogin(){
        return "ok";
    }


   //当请求路径是/testParms 并且请求参数含有：usesrname和password时，才能映射成功
   //不符合报400
    @RequestMapping(value = "/testParams",params ={"username!=嘉嘉","password"})
    public String testParams(){
        return "ok";
    }


    //不符合报404
    @RequestMapping(value = "/testHeaders",headers = {"Referer","Host"})
    public String testHeaders(){
        return "ok";
    }
}
