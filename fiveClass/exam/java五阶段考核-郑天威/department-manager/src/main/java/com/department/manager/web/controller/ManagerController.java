package com.department.manager.web.controller;

import com.department.manager.domain.Department;
import com.department.manager.domain.User;
import com.department.manager.service.DepartmentService;
import com.department.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * @author 夜神
 */
@Controller
@RequestMapping("/manager")
@SessionAttributes(value = {"sessionDepartment","sessionUser","baseDepartment","baseUser"} ,
        types = {Department.class,User.class,Department.class,User.class})
public class ManagerController {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;
    /**
     * @return
     * @discription to login page
     */
    @GetMapping("/login")
    public String login(Model model) {
        Department sessionDepartment=new Department();
        User sessionUser=new User();
//        基础列表
       List<Department>  baseDepartment=this.departmentService.allDepartmentList();
        List<User> baseUser=this.userService.allUser();
//        修改时用来回显的session域department,必须在进入页面前就已经存在，在此先创建
        model.addAttribute("sessionDepartment",sessionDepartment);
        model.addAttribute("sessionUser",sessionUser);
        model.addAttribute("baseDepartment",baseDepartment);
        model.addAttribute("baseUser",baseUser);

        return "login";
    }
}
