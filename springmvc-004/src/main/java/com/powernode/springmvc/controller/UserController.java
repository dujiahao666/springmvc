package com.powernode.springmvc.controller;

import com.powernode.springmvc.pojo.User;
import com.powernode.springmvc.pojo.UserBean;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/19 0:52
 * @description:
 */
@Controller
public class UserController {

    @RequestMapping("/")
    public String toRegister() {
        return "register";
    }

    //    @RequestMapping(value = "/user/req",method = RequestMethod.POST)
    @PostMapping(value = "/user/reg")
    public String register(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);

        //获取请求提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String[] parameterValues1 = request.getParameterValues("interest");
        String intro = request.getParameter("intro");

        //展示数据
        System.out.println("用户名是：" + username);
        System.out.println("密码是：" + password);
        System.out.println("性别是：" + sex);
        System.out.println("爱好是：" + Arrays.toString(parameterValues1));
        System.out.println("简介信息是：" + intro);
        return "ok";
    }

    @PostMapping(value = "/user/reg2")
    public String register2(@RequestParam(value = "username")
                            String usernameOK,
                            @RequestParam(value = "password")
                            String b,
                            @RequestParam("sex")
                            String c,
                            @RequestParam("interest")
                            String d,
                            @RequestParam("intro")
                            String intro) {
        System.out.println("姓名是：" + usernameOK);
        System.out.println("密码是：" + b);
        System.out.println("性别是：" + c);
        System.out.println("爱好是：" + d);
        System.out.println("简介是:" + intro);
        System.out.println("展示完毕");
        return "ok";
    }


    @PostMapping(value = "/user/reg3")
    public String register3(String username, Integer password, String sex, String interest, String intro) {
        System.out.println("姓名是：" + username);
        System.out.println("密码是：" + password);
        System.out.println("性别是：" + sex);
        System.out.println("爱好是：" + interest);
//        System.out.println("爱好是：" + Arrays.toString(interest));
        System.out.println("简介是:" + intro);
        System.out.println("展示完毕了嘉嘉！");
        return "ok";
    }



    @PostMapping(value = "/user/reg4")
    public String register4(UserBean user){
        System.out.println(user);
        return "ok";
    }

    @PostMapping(value = "/user/reg5")
    public String register5(String username, Integer password,
                            @RequestParam("password") String pawd,
                            String sex, String interest,
                            String intro,
                            HttpServletRequest request,
                            User user,
                            @RequestParam("username") String usn) {
        System.out.println("姓名是：" + username);
        System.out.println("密码是：" + password);
        System.out.println("性别是：" + sex);
        System.out.println("爱好是：" + interest);
        System.out.println("简介是:" + intro);
        System.out.println("展示完毕了嘉嘉！");
        System.out.println("姓名是（重新获取的：)" + usn);
        System.out.println("密码是（重新获取的：)" + pawd);
        System.out.println(user);
        String username1 = request.getParameter("username");
        System.out.println("tomcat发来了请求:"+username1);
        return "ok";
    }


    @GetMapping(value = "/user/reg55")
    public String register55(HttpServletRequest request,HttpServletResponse response){
        Cookie cookie=new Cookie("keya","这是系统携带的数据1");
        Cookie cookie2=new Cookie("keyb","这是系统携带的数据2");
        response.addCookie(cookie);
        response.addCookie(cookie2);
        response.setContentType("text/html;charset=UTF-8");
        return "cookie";
    }



    @PostMapping(value = "/user/reg6")
    public String register5(UserBean userBean,
                            @RequestHeader(value = "Connection",required = true)
                            String connection,
                            @RequestHeader(value = "Referer",required = false)
                            String Referer,
                            @CookieValue(value = "keya")
                            String keyA,
                            @CookieValue(value = "keyb")
                            String keyB
                            ){
        System.out.println("提交用户的信息是："+userBean);
        System.out.println("Connection请求头的信息是："+connection);
        System.out.println("Refer请求头的信息是："+Referer);
        System.out.println("=================");
        System.out.println("cookie携带的信息一号："+keyA);
        System.out.println("cookie携带的信息二号："+keyB);
        return "ok";
    }



    @RequestMapping(value = "/user/reg7")
    public String register7(UserBean user){
        System.out.println(user);
        return "ok";
    }

}
