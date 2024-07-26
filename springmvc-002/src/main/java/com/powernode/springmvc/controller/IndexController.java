package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/17 9:52
 * @description:
 */
@Controller
public class IndexController {
    //作： 请求路径和方法之间的 映射关系
    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/first")
    public String first(){
        System.out.println("业务逻辑正在处理中...");
        //返回一个逻辑视图名称
        return "first";
    }
}
