package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/11 10:45
 * @description:
 */
@Controller
public class RestfulController {
//    这种方式 后面加 ?uesr=12也是ok的
    @RequestMapping("/jk1/{username}/{password}")
    public String  ref1(@PathVariable("username")String u,@PathVariable("password")String p){
        System.out.println("用户名："+u);
        System.out.println("密码："+p);
        return "bi";
    }

//    这种方式虽然是精确匹配的，但是？usesr=23这种没有被约束，可以随意
    @RequestMapping("/eer")
    public String ref2(){
        return "bi";
    }

    @RequestMapping("/aa/{iop}")
    public String ref3(@PathVariable("iop")String ui){
        System.out.println("来过来的是："+ui);
        return "bi";
    }

    @RequestMapping("/aa1")
    public String ref4(String name){
        System.out.println("来过来的是："+name);
        return "bi";
    }


    @RequestMapping("/us")
    public String s(){
        return "del";
    }

    @DeleteMapping("/user/{id}")
    public String wq(@PathVariable String id){
        System.out.println("被删除用户的id是："+id);
        return "ok";
    }
}
