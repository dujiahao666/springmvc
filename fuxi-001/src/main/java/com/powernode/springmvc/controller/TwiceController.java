package com.powernode.springmvc.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.plaf.PanelUI;
import java.util.Map;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/11 1:41
 * @description:
 */
@Controller
@SessionAttributes(value = {"methoda"})
public class TwiceController {

    @GetMapping("/b")
    public String toOk(){
        return "ok";
    }


//     org.springframework.ui
    @RequestMapping("/request")
    public String req(Model model){
        model.addAttribute("method","这是方式一");
        return "ok";
    }

    @RequestMapping("/request2")
    public String req(Map<String,Object> map){
        map.put("method","这是方式2");
        return "ok";
    }

    @RequestMapping("/request3")
    public String req3(ModelMap modelMap){
        modelMap.addAttribute("method","这是方式3");
        return "ok";
    }

    @RequestMapping("/request4")
    public ModelAndView req4(ModelAndView view){
        ModelAndView mv=new ModelAndView();
        mv.addObject("method","这是方式4");
        mv.setViewName("ok");
        return mv;
    }

    @RequestMapping("/session1")
    public String se1(ModelMap modelMap){
        modelMap.addAttribute("methoda","这是seesion方法获取到的...方式一");
        return "ok";
    }

    @RequestMapping("/app1")
    public String se2(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("methodb","如果有天你还爱着我...");
        return "ok";
    }

    @RequestMapping("/dian")
    public String dian(ModelMap modelMap){
        modelMap.addAttribute("sea","这就是力量");
        return "dian";
    }


}
