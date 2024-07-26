package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/17 11:01
 * @description:
 */
@Controller
@RequestMapping("/user")
//这个注解表示，将这个类中后续的所有requestMapping的路径前面都加上:  /user
public class UserController {

//    @RequestMapping("/user/detail")
//    @RequestMapping("/detail")
//    @RequestMapping( {"/a","/b"})
//    @RequestMapping("/x?")
//    @RequestMapping("/x*")
    @RequestMapping("/x/**")
    public String userDetail() {
        return "user_detail";
    }
}

