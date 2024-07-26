package com.powernode.usermgt.dao;

import com.powernode.usermgt.bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/25 22:35
 * @description:
 */
@Repository
public class UserDao {

    private static List<User> users = new ArrayList<>();

    static {
        //类加载是初始化数据
        //创建User对象
        User user1 = new User(1001L, "张三", 1, "zhangsan@powernode.com");
        User user2 = new User(1002L, "孙悟空", 1, "wukong@powernode.com");
        User user3 = new User(1003L, "猪八戒", 1, "bajie@powernode.com");
        User user4 = new User(1004L, "白骨精", 0, "bgj@powernode.com");
        User user5 = new User(1005L, "武松", 1, "ws@powernode.com");
        //将User对象存储到List集合中
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    public List<User> selectAll() {
        return users;
    }


    public Long generate() {
        Long max = users.get(0).getId();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() > max) {
                max = users.get(i).getId();
            }
        }
        return max + 1;
    }

    public void insert(User user) {
        Long id = generate();
        user.setId(id);
        users.add(user);
    }


    public User selectById(Long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                return users.get(i);
            }
        }
        return null;
    }


    public void modify(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i,user);
                return;
            }
        }
    }

    public void  deleteById(Long id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)){
                users.remove(i);
                return;
            }
        }
    }


}
