package com.yanqi.petmanager.service.impl;

import com.yanqi.petmanager.dao.UserMapper;
import com.yanqi.petmanager.pojo.User;
import com.yanqi.petmanager.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String userpwd) {
        User user = userMapper.getByUsername(username);
        if (user != null){
            if (!userpwd.equals(user.getUserpassword())){
                user.setUsername(null);
            }
        }
        return user;
    }
}
