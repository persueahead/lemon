package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.User;
import com.bjlemon.mybatis.vo.UserQueryVO;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName PersonMapper.java
 * @Description TODO
 * @createTime 2020年03月03日 21:45:00
 */
public interface UserMapper {

    List<User> findUsersByQueryVO(UserQueryVO userQueryVO);

    List<User> findUsersByIds(Integer[] ids);

    List<User> findUsersByIdList(List<Integer> idList);

}
