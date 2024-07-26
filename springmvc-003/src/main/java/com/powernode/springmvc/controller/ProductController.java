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
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/detail")
    public String product_Detail() {
        return "product_detail";
    }
}
