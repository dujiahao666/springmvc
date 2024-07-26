package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/16 10:16
 * @description:
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String toIndex(){
//        int i=10;
//        i=i/0;
        return "index";
    }
}