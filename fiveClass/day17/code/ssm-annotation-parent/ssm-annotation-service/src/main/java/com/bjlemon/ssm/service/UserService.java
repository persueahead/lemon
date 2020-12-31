package com.bjlemon.ssm.service;

import com.bjlemon.ssm.domain.User;
import com.bjlemon.ssm.vo.UserQueryVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    List<User> findAllUserList();

    /**
     * 查询用户分页列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<User> findUserPaginationList(Integer pageNum, Integer pageSize);

    PageInfo<User> findUserPaginationListByCondition(Integer pageNum, Integer pageSize, UserQueryVO userQueryVO);

    void addUser(User user);
}
