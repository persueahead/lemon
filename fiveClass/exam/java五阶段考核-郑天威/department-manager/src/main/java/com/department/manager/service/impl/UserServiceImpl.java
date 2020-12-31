package com.department.manager.service.impl;


import com.department.manager.domain.User;
import com.department.manager.domain.UserExample;
import com.department.manager.mapper.DepartmentMapper;
import com.department.manager.mapper.UserMapper;
import com.department.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public int addUser(User user) {
        return this.userMapper.insertSelective(user);
    }

    @Override
    public List<User> allUser() {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
//        查询所有user
        List<User> userList = this.userMapper.selectByExample(userExample);
        for (User user : userList) {
            String depName = this.departmentMapper.selectByPrimaryKey(user.getDepId()).getDepName();
            user.setDepName(depName);
        }
        return userList;
    }

    @Override
    public int updateUserSelective(User user) {
        return this.userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUsers(int[] userIds) {
        int flag = 0;
        for (int id : userIds) {
            User user = new User();
            user.setUserId(id);
            user.setUserState(1);
            flag = this.userMapper.updateByPrimaryKeySelective(user);
        }
        return flag;
    }

    @Override
    public void rebuildBaseUser(List<User> userList, Model model) {
        userList = this.allUser();
        model.addAttribute("baseUser", userList);
    }

    @Override
    public List<User> selectUserWithLike(User user) {
        List<User> userList=null;
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
//        userName查询
        if (user.getUserName() != null) {
            criteria.andUserNameEqualTo(user.getUserName());
        }
//        depId查询
        if (user.getDepId()!=null&&user.getDepId() > 0) {
            criteria.andDepIdEqualTo(user.getDepId());
        }
//        userId查询
        if (user.getUserId()!=null&&user.getUserId()>0){
            criteria.andUserIdEqualTo(user.getUserId());
        }
        try{
           userList = this.userMapper.selectByExample(userExample);
//           加上部门名称
           for (User userInList:userList){
               String depName=this.departmentMapper.selectByPrimaryKey(userInList.getDepId()).getDepName();
               userInList.setDepName(depName);
           }
        }catch(Exception e){
//            查不到就返回空user
            userList=new ArrayList<User>();
        }

        return userList;
    }
}
