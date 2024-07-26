package com.powernode.springmvc.controller;

import com.powernode.springmvc.bean.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.net.URI;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/28 22:22
 * @description:
 */
@Controller
public class RequestBodyController {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody String str) {
        System.out.println("请求体是：" + str);
        return "ok";
    }


    @PostMapping("/save2")
    @ResponseBody
    public String save2(@RequestBody User user) {
        System.out.println("返回的数据是："+user);
        //不是逻辑视图名称，是普通字符串，因为前端发送的请求是AJAX请求。
        return "ok";
    }

    @PostMapping("/save3")
    @ResponseBody
    public String save3(RequestEntity<User> request) {
        HttpMethod method = request.getMethod();
//        System.out.println("请求方法是："+method);
//        Object body = request.getBody();
//        System.out.println("请求体是："+body);
//        URI url = request.getUrl();
//        System.out.println("路径是："+url);
//        System.out.println("user:"+request);
//        System.out.println("request本身是："+request);
//        HttpHeaders headers = request.getHeaders();
//        System.out.println("请求头信息是："+headers);
        System.out.println("请求体："+request);
        return "ok";
    }


    @GetMapping("hah")
    @ResponseBody
    public String da(RequestEntity request){
        System.out.println("请求方式"+request.getMethod());
        System.out.println("请求体："+request.getBody());
        return "ok";
    }

}
