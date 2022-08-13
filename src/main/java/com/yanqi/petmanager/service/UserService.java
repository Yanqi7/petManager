package com.yanqi.petmanager.service;

import com.yanqi.petmanager.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User login(String username,String userpwd);
}
