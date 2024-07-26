package com.powernode.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/20 22:17
 * @description:
 */
@Controller
//处理类
public class RequestScopeController {

    //处理方法
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        //将共享的数据存储到equest域当中
//        request.setAttribute("testRequestScope","在SpringMVC当中使用原生的servlet API完成request域数据共享。嘎嘎嘎");
        request.setAttribute("xin1","在SpringMVC当中使用原生的servlet API完成request域数据共享。嘎嘎嘎漂【原生方式】");
        //跳转视图，在视图页面将request域中的数据读取出来，这样就完成了；Controller和View在同一个请求当中两个组件之间的数据共享

        //这个跳转，默认情况下是：转发的方式（转发forword是一次请求）
        //这个返回的是一个逻辑视图名称，经过视图解析器解析，变成无力视图名称。 /web-inf/templates/ok.html
        return "ok";
    }

    @RequestMapping("/testServletAPI2")
    public String testServletAPI2(Model model){
        model.addAttribute("xin1","这是信息1【方式2】");
        model.addAttribute("xin2","这是信息2");
        return "ok";
    }

    @RequestMapping("/testServletAPI3")
    public String testServletAPI3(Map<String,Object> map){
        map.put("xin1","当前数据是由map集合传来的1号【方式3】");
        map.put("xin2","当前数据是由map集合传来的2号");
        return "ok";
    }


    @RequestMapping("/testServletAPI4")
    public String testServletAPI4(ModelMap modelMap){
        modelMap.addAttribute("xin1","当前数据是由moudelmap传来的1号【方式4】");
        modelMap.addAttribute("xin1","当前数据是由moudelmap传来的2号【方式4】");
        return "ok";
    }


    @RequestMapping("/testServletAPI5")
    public ModelAndView testServletAPI5(){
       ModelAndView modelAndView=new ModelAndView();
       modelAndView.addObject("xin1","当前数据是由modelAndView传来的。【方式5】");
       modelAndView.addObject("xin2","当前数据是由modelAndView传来的。【方式5】");
       modelAndView.setViewName("ok");
       return modelAndView;
    }


}
