package com.yanqi.petmanager.dao;

import com.yanqi.petmanager.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getAll();
    User getByUsername(String username);

}
