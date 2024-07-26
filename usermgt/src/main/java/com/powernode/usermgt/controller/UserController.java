package com.powernode.usermgt.controller;

import com.powernode.usermgt.bean.User;
import com.powernode.usermgt.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/25 22:30
 * @description:
 */
@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String list(ModelMap modelMap){
        //查询数据库，获取用户列表List集合
        List<User> users=userDao.selectAll();
        //将用户列表存储到request域当中
        modelMap.addAttribute("users",users);
        //转发到视图
        return "user_list";
    }



    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String add(User user){
        //调用userDao保存用户信息
        userDao.insert(user);
        //重定向到用户列表页面（重新让浏览器发送一次全新的请求，去请求列表页面）
        return "redirect:/user";
    }


    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Model model){
        User user = userDao.selectById(id);
        model.addAttribute("user",user);
        return "user_edit";
    }


    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String modify(User user){
        userDao.modify(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id){
        userDao.deleteById(id);
        return "redirect:/user";
    }

}
