package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/16 22:14
 * @description: 处理请求返回逻辑视图名称
 */
@Controller
public class FirstController {

    //请求映射
    //这个方法是一个实例方法，这个方法目前返回一个String字符串
    //返回值代表的是一个逻辑视图名称【最后被拼成物理视图名称】
    @RequestMapping("/test")
    public String hehe(){
        //返回一个逻辑视图名称
        return "first";
    }


    @RequestMapping("/heihei")
    public String haha(){
        //处理核心业务
        //返回一个逻辑视图名称
        return "other";
    }


    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

}
