package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.User;
import com.bjlemon.mybatis.vo.UserQueryVO;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2019年12月28日 21:47:00
 */
public interface UserMapper {

    void save(User user);

    void persist(User user);

    List<User> findByIds(Integer[] ids);

    List<User> findByIdList(List<Integer> idList);

    /**
     * @throws
     * @title
     * @description 根据查询条件查询用户
     * @author admin
     * @updateTime 2019/12/28 21:51
     */
    List<User> findByCondition(UserQueryVO userQueryVO);

    void update(User user);

    User findById(Integer id);

}
