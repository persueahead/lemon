package com.bjlemon.springboot.mapper;

import com.bjlemon.springboot.domain.User;

import java.util.List;

public interface UserMapper {

    List<String> findRoleNameListByUserId(Integer userId);

    User findUserByName(String name);
}