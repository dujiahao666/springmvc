package com.powernode.springmvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/21 22:48
 * @description:
 */
@Controller
public class ApplicationScopeTestController {

    @RequestMapping("/app")
    public String app(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("xin1","这是应用域的信息");
        return "app";
    }
}
