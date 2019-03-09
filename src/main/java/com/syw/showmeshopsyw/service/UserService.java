package com.syw.showmeshopsyw.service;

import com.syw.showmeshopsyw.entity.User;
import com.syw.showmeshopsyw.mapper.UserMapper;
import com.syw.showmeshopsyw.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public void login(User user){
        User current= userMapper.login(user);
        if(null==current){
            try {
                throw new Exception("账号或密码错误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            UserUtil.setCurrentUser(current);
        }
    }
    public User get(Integer id){
        return userMapper.get(id);
    }
    public void register(User user){
        userMapper.register(user);
    }
}
