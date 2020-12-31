package com.bjlemon.springboot.mapper;

import com.bjlemon.springboot.domain.Permission;
import com.bjlemon.springboot.domain.User;
import com.bjlemon.springboot.domain.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * @description 根据用户编号查询该用户的权限
     * @author admin
     * @updateTime 2020/2/18 21:14
     */
    List<Permission> findPermissionsByUserId(Integer userId);
}