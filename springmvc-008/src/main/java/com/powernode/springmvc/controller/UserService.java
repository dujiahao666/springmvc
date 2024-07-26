package com.powernode.springmvc.controller;

import com.powernode.springmvc.bean.User;
import org.springframework.stereotype.Service;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/28 23:50
 * @description:
 */
@Service
public class UserService {
    public User getById(Long id){
        if(id==1){
            return new User(111l,"zhangsan","1234");
        }
        return null;
    }
}
