package com.department.manager.service;

import com.department.manager.domain.Department;
import com.department.manager.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;


public interface UserService {
    /**
     * 增加员工
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 查所有uer
     * @return
     */
    List<User> allUser();

    /**
     * 修改user
     * @param user
     * @return
     */
    int updateUserSelective(User user);

    /**
     * 按id批量删除user（假删除）
     * @param userIds
     * @return
     */
    int deleteUsers(int[] userIds);

    /**
     * 重建baseUser数据,
     * @param userList 一定要是session域的baseUser
     */
    void rebuildBaseUser(List<User> userList,Model model );

    /**
     * 按员工名称 or 部门名称 模糊查询
     * @param user
     */
    List<User> selectUserWithLike(User user);
}
