package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/30 19:39
 * @description:
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello(){
        System.out.println("HelloController#hello()");
        return "hello";
    }


}
