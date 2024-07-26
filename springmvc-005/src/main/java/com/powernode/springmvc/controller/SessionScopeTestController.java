package com.powernode.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/21 22:09
 * @description:
 */
@Controller
@SessionAttributes({"xin1","xin2"})
public class SessionScopeTestController {
    @RequestMapping("/session1")
    public String sessionApi(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("xin1", "这是使用原生方式的session域信息一");
        session.setAttribute("xin2", "这是使用原生方式的session域信息二");
        return "session";
    }


//    @RequestMapping("/session2")
//    public String sessionApi2(Model model) {
//        model.addAttribute("xin1", "方式二的session域信息一");
//        model.addAttribute("xin2", "方式二的session域信息二");
//        return "session";
//    }

    @RequestMapping("/session2")
    public String sessionApi2(Map<String,Object> map) {
        map.put("xin1","map的信息1");
        map.put("xin2","map的信息2");
        return "session";
    }

    @RequestMapping("/session3")
    public String sessionApi3(Model model) {
        return "session";
    }
}
