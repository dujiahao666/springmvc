package com.powernode.springmvc.controller;

import com.powernode.springmvc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/28 23:45
 * @description:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET )
    public ResponseEntity getById(@PathVariable("id") Long id){
        User user=userService.getById(id);
        if(user==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else {
            return ResponseEntity.ok(user);
//            return ResponseEntity.status(HttpStatus.OK).body(user);
//            return ResponseEntity.status(200).body(user);
        }
    }

}
