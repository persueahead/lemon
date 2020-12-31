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
import java.util.Arrays;
import java.util.List;

/**
 * @author 夜神
 */
@Controller
@RequestMapping("/department")
@SessionAttributes(value = {"sessionDepartment", "baseDepartment"}, types ={Department.class} )
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private UserService userService;

    /**
     * 进入基础部门列表
     * @param model
     * @param baseDepartment
     * @return
     */
    @GetMapping("/departmentIndex")
    @Secured("ROLE_ADMIN")
    public String getIndex(Model model,
                           @SessionAttribute("baseDepartment") List<Department> baseDepartment) {
        this.departmentService.rebuildBaseDepartment(baseDepartment, model);
        return "/department/showDepartment";
    }

    /**
     * 进入添加部门视图
     *
     * @return
     */
    @GetMapping("/add")
    @Secured({"ROLE_ADMIN"})
    public String add() {
        return "/department/addDepartment";
    }

    /**
     * 进行添加操作
     *
     * @param department
     */
    @PostMapping("/addDepartmentImpl")
    @Secured("ROLE_ADMIN")
    public String addDepartment(Department department,
                                Model model,
                                @SessionAttribute("baseDepartment") List<Department> baseDepartment) {
//        添加部门
        int i = this.departmentService.addDepartment(department);
        if (i!=0){
            model.addAttribute("tip","添加成功");
        }
//        携带全部部门
        this.departmentService.rebuildBaseDepartment(baseDepartment, model);
//        返回部门列表
        return "/department/showDepartment";
    }

    /**
     * 进入删除页面
     *
     * @return
     */
    @GetMapping("/delete")
    @Secured({"ROLE_ADMIN"})
    public String delete(Model model) {
//        查询部门数据
        List<Department> preDeleteDepartment = this.departmentService.allDepartmentList();
//        存入删除前的数据
        model.addAttribute("preDeleteDepartment", preDeleteDepartment);
        return "/department/deleteDepartment";
    }

    /**
     * 执行删除操作
     *
     * @param ids
     * @param model
     * @return
     */
    @PostMapping("/deleteImpl")
    @Secured("ROLE_ADMIN")
    public String deleteDepartment(@RequestParam("ids") int[] ids,
                                   Model model,
                                   @SessionAttribute("baseDepartment") List<Department> baseDepartment) {

        for (int id:ids){
            User user=new User();
            user.setDepId(id);;
//            查看id部门下有没有员工
            int flag=this.userService.selectUserWithLike(user).size();
            if (flag>0){
                model.addAttribute("tip","有部门仍有员工，不能删除!!!");
                this.departmentService.rebuildBaseDepartment(baseDepartment,model);
                return "/department/showDepartment";
            }
        }
//        按id删除
        this.departmentService.deleteDepartmentById(ids);
//        重查所有部门
        this.departmentService.rebuildBaseDepartment(baseDepartment, model);
        return "/department/showDepartment";
    }

    /**
     * 进入修改页面
     * 携带能够修改的id
     *
     * @return
     */
    @GetMapping("/modify")
    @Secured({"ROLE_ADMIN"})
    public String modify(Model model,
                         @SessionAttribute("sessionDepartment") Department sessionDepartment) {
//        获取所有部门编号
        List<Department> departmentList = this.departmentService.allDepartmentList();
        ArrayList<Integer> departmentIdList = new ArrayList<>();
//        有没有部门可供修改,有则放入部门编号
        int flag = 0;
        if (departmentList != null) {
            for (Department department : departmentList) {
                departmentIdList.add(department.getDepId());
            }
            flag = 1;
        }
        model.addAttribute("idList", departmentIdList);
        model.addAttribute("flag", flag);
//        System.out.println("携带:"+sessionDepartment);
        model.addAttribute("sessionDepartment", sessionDepartment);
        return "/department/modifyDepartment";
    }

    /**
     * 提交修改
     * 携带提交的修改信息，修改数据库
     *
     * @param preDepartment 姐搜提交的信息
     * @param model         将preDepartment放到session域
     * @return
     */
    @PostMapping("/modifyDepartmentImpl")
    @Secured({"ROLE_ADMIN"})
    public String modifyImpl(Department preDepartment,
                             Model model,
                             @SessionAttribute("sessionDepartment") Department sessionDepartment,
                             @SessionAttribute("baseDepartment") List<Department> baseDepartment) {
//        打印获取的提交信息和之前的session域的初始department（为null）
//        System.out.println(preDepartment);
//        System.out.println(sessionDepartment);
//        将提交的修改信息存到session域
        sessionDepartment = preDepartment;
//        赋值后的session域的department
//        System.out.println(sessionDepartment);
//        按id修改数据库
        int i=this.departmentService.modifyDepartment(preDepartment);
        if (i!=0){
            model.addAttribute("tip","操作成功");
        }
//        携带全部部门
        this.departmentService.rebuildBaseDepartment(baseDepartment, model);
//        覆盖session域数据回显的值
        model.addAttribute("sessionDepartment", sessionDepartment);
//        返回list页面
        return "/department/showDepartment";
    }

    /**
     * 进入查询页面
     *
     * @return
     */
    @GetMapping("/select")
    @Secured({"ROLE_ADMIN"})
    public String select(Model model) {
        Department department = new Department();
        model.addAttribute("selectDepartment", department);
        return "/department/selectDepartment";
    }

    /**
     * 查询处理
     *
     * @param model
     * @return
     */
    @PostMapping("/selectImpl")
    @Secured({"ROLE_ADMIN"})
    public String selectDepartment(Model model, @RequestParam("depName") String depName) {
        Department department = this.departmentService.selectByDepartmentName(depName);
        if (department.getDepName() != null) {
            model.addAttribute("selectDepartment", department);
            model.addAttribute("selectTip", "查询成功");
        } else {
            model.addAttribute("selectTip", "没有这个部门");
            model.addAttribute("selectDepartment", new Department());
        }

        return "/department/selectDepartment";
    }

    /**
     * 用部门id查看部门员工
     * @param depId
     * @param model
     * @return
     */
    @GetMapping("/selectUser")
    @Secured("ROLE_ADMIN")
    public String getUserInDepartment(@RequestParam("depId") int depId, Model model) {
        User user = new User();
        user.setDepId(depId);
//        根据部门id查所有user
        List<User> users = this.userService.selectUserWithLike(user);
        model.addAttribute("users", users);
        return "/department/userInDepartment";
    }
}
