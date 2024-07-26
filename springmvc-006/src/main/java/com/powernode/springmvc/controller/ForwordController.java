package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/22 21:07
 * @description:
 */
@Controller
public class ForwordController {

    @RequestMapping("/a")
    public String toA() {
        //返回的是一个逻辑视图名称
        //return "a";

        //采用SpringMVC的转发方式跳转到 /b
        //转发的时候，格式有特殊要求： return "forward:下一个资源的路径";
        //这个就不是逻辑视图名称了
//        return "forward:/b";  //创建InternalResourceView对象。
//        return "forward:b";  //创建InternalResourceView对象。
        return "redirect:/b";
//        return "redirect:b";
    }

    @RequestMapping("/b")
    public String toB() {
        return "b";
//        return "redirect:/b";
    }


//    @RequestMapping("/c")
//    public String toC() {
//        return "c";
//    }

}
