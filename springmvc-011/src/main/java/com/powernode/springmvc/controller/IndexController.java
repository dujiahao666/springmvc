package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/30 12:30
 * @description:
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String toIndex(){
        System.out.println("IndexController#toIndex ------> 处理方法执行了...");
        return "index";
    }

    @RequestMapping("/ok")
    public String toOK(){
        System.out.println("IndexController#ok ------> 处理方法执行了...");
        return "ok";
    }
}
