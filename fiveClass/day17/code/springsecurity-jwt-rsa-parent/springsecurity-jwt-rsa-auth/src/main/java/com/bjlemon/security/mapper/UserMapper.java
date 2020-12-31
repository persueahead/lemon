package com.bjlemon.security.mapper;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2020年02月20日 21:05:00
 */
public interface UserMapper {


    UserDetails findByName(String username);
}
