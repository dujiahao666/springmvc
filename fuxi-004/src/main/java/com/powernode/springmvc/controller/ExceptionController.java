package com.powernode.springmvc.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/16 10:29
 * @description:
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    public String tip(Exception e, Model model){    //这里的第二个参数只能使用 Model [Map MdeolMap都不可]
        model.addAttribute("yichang",e);
        return "tip";
    }
}
