package com.powernode.springmvc.controller;

import com.powernode.springmvc.pjo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/10 12:41
 * @description:
 */
//因为这个对象的声明周期要完全交给spring的ioc来管理
@Controller
public class FirstController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/zhen")
    public String zhen(){
        return "zhen";
    }

    @RequestMapping("/first")
    public String first(){
        return "first";
    }

    /*@GetMapping("/jiao")
    public String jaio(String username,  Integer password){
        System.out.println("用户名是："+username);
        System.out.println("密码是："+password);
        return "ok";
    }*/


    //这种情况都是可以的，可以重复去取值
    @GetMapping("/jiao")
    public String jaio(Person person,String username,@RequestParam("username")String x){
        System.out.println("信息是："+person);
        System.out.println("username是："+username);
        System.out.println("用了注解是："+x);
        return "ok";
    }

    @RequestMapping("/A")
    public String dao1(){
        return "redirect:/B";
    }


    @RequestMapping("/B")
    public String dao2(){
        return "b";
    }




}
