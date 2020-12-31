package com.department.manager.web.controller;

import com.department.manager.domain.Department;
import com.department.manager.domain.User;
import com.department.manager.service.DepartmentService;
import com.department.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"baseUser", "sessionUser"}, types = {User.class})
public class UserController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private UserService userService;

    /**
     * 进入基础列表
     * @param model
     * @param baseUser
     * @return
     */
    @GetMapping("/userIndex")
    @Secured("ROLE_ADMIN")
    public String getIndex(Model model,
                           @SessionAttribute("baseUser")List<User> baseUser){
        this.userService.rebuildBaseUser(baseUser,model);
        return "/user/showUser";
    }

    /**
     * 进入增加员工页面
     * 携带部门以调用部门名
     *
     * @return
     */
    @GetMapping("/add")
    @Secured({"ROLE_ADMIN"})
    public String add(Model model) {
//        查询所有可用部门
        List<Department> departmentList = this.departmentService.allDepartmentList();
        model.addAttribute("departmentList", departmentList);
        return "/user/addUser";
    }

    /**
     * 执行添加操作
     *
     * @param user     接收提交user信息
     * @param depName  接收提交部门名称
     * @param baseUser 覆盖基础列表
     * @param model    用来传递session域baseUser
     * @return 跳转列表
     */
    @PostMapping("/addImpl")
    @Secured({"ROLE_ADMIN"})
    public String addImpl(User user,
                          @RequestParam("depName") String depName,
                          @SessionAttribute("baseUser") List<User> baseUser,
                          Model model) {
        System.out.println(user);
//        通过部门名获取department
        Department department = this.departmentService.selectByDepartmentName(depName);
        user.setDepId(department.getDepId());
//        向数据库增加数据 得到完整user数据信息
        int tip = this.userService.addUser(user);
        if (tip != 0) {
            model.addAttribute("tip", "操作成功");
        }
//        重新查一次所有 ,并给每个user对象附上depName
        this.userService.rebuildBaseUser(baseUser, model);
        return "/user/showUser";
    }


    /**
     * 进入删除页面
     * @return
     */
    @GetMapping("/delete")
    @Secured({"ROLE_ADMIN"})
    public String delete(Model model) {
        List<User> preDeleteUsers = this.userService.allUser();
        model.addAttribute("preDeleteUsers",preDeleteUsers);
        return "/user/deleteUser";
    }

    @PostMapping("/deleteImpl")
    @Secured({"ROLE_ADMIN"})
    public String deleteImpl(Model model,
                             @RequestParam("ids")int[] userIds,
                             @SessionAttribute("baseUser")List<User> baseUser) {

        int i = this.userService.deleteUsers(userIds);
        if (i != 0) {
            model.addAttribute("tip","操作成功");
        }else {
            model.addAttribute("tip","操作失败");
        }
        this.userService.rebuildBaseUser(baseUser,model);
        return "/user/showUser";
    }

    /**
     * 进入修改页面
     *
     * @return
     */
    @GetMapping("/modify")
    @Secured({"ROLE_ADMIN"})
    public String modify(@SessionAttribute("sessionUser") User sessionUser,
                         Model model) {
//        查询所有员工
        List<User> userList = this.userService.allUser();
//        为空标记
        int flag = 0;
        if (userList != null) {
            flag = 1;
        }
        List<Department> departmentList=this.departmentService.allDepartmentList();
//        所有部门，用来选择部门
        model.addAttribute("departmentList",departmentList);
        model.addAttribute("userList", userList);
        model.addAttribute("flag", flag);
        model.addAttribute("sessionUser", sessionUser);
        return "/user/modifyUser";
    }

    @PostMapping("/modifyImpl")
    @Secured("ROLE_ADMIN")
    public String modifyImpl(User user,
                             Model model,
                             @SessionAttribute("sessionUser") User sessionUser,
                             @SessionAttribute("baseUser")List<User> baseUser) {
        System.out.println(user);
//        根据提交的部门名称设置depId，user更改depId，即可更改部门名，数据库中user是没有部门名的不能直接通过名称更改所属部门
        Integer depId = this.departmentService.selectByDepartmentName(user.getDepName()).getDepId();
        user.setDepId(depId);
//        修改数据
        int i = this.userService.updateUserSelective(user);
        if (i!=0){
            model.addAttribute("tip","修改成功");
        }
//        保存提交的信息
        sessionUser=user;
        System.out.println(sessionUser);
//        更新baseUser
        this.userService.rebuildBaseUser(baseUser,model);
        model.addAttribute("sessionUser",sessionUser);
//        返回列表
        return "/user/showUser";
    }

    /**
     * 进入查询页面
     * @return
     */
    @GetMapping("/select")
    @Secured({"ROLE_ADMIN"})
    public String select(Model model) {
        List<User> selectUserList=new ArrayList<>();
        int length = selectUserList.size();
//        开始传没有数据的，隐藏信息表格
        model.addAttribute("length",length);
        model.addAttribute("selectUserList",selectUserList);
        return "/user/selectUser";
    }

    /**
     * 查询处理页面
     * @param model
     * @return
     */
    @PostMapping("/selectImpl")
    @Secured({"ROLE_ADMIN"})
    public String selectImpl(Model model,
                             User user) {
        int depId;
        try{
            depId=this.departmentService.selectByDepartmentName(user.getDepName()).getDepId();
        }catch(Exception e){
            depId=0;
        }

//        将名称条件转换为id条件,depId不能为null，否则set方法报错
        user.setDepId(depId);
//        按名称 or 部门 模糊查询

        List<User> selectUserList = this.userService.selectUserWithLike(user);
        int length = selectUserList.size();
        if (length>0){
            model.addAttribute("selectTip","操作成功");
        }else {
            model.addAttribute("selectTip","查询失败");
        }
        model.addAttribute("length",length);
        model.addAttribute("selectUserList",selectUserList);
        return "/user/selectUser";
    }
}
