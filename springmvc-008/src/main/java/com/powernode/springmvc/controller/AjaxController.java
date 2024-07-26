package com.powernode.springmvc.controller;

import com.powernode.springmvc.bean.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/28 9:55
 * @description:
 */
//@RestController
@Controller
public class AjaxController {


    @RequestMapping(value = "/ajax1", method = RequestMethod.GET)
    public String ajax1(HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("hello ajax,i am springmvc1");
        return null;
    }

    @RequestMapping(value = "/ajax2", method = RequestMethod.GET)
    public void ajax2(HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("hello ajax,i am springmvc2");
    }

    @RequestMapping(value = "/ajax3", method = RequestMethod.GET)
    @ResponseBody
    //当处理器方法上添加了 @ResponseBody 注解，那么这个方法的返回值不再是逻辑视图名称了，而是直接将字符串返回给浏览器。给ajax
    public String ajax3() {
        //return "这真是个好东西";
        return "{\"id\":\"111\",\"username\":\"张三\",\"password\":\"123456\"}";
    }



    //当添加了@ResponseBody注解之后，如果返回值类型是对象，springmvc会自动将这个对象转换成json字符并响应，注意。需要添加jaskson依赖
    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    @ResponseBody
    public User ajax4() {
        User user = new User(111l, "嘉嘉2号", "15968");
        return user;
    }


//    @PostMapping(value = "/save")
//    @ResponseBody
//    public String jie(@RequestBody String str){
//        System.out.println(str);
//        return "ok";
//    }

    @RequestMapping("/aaa")
    public void sd(){
     //若是直接浏览器返回的时候，如果没有给定的返回。就安value去拼接，前后，如这个，就返回的是aaa.html
     //但是ajax的时候，却不是这种处理方式。
    }


}
