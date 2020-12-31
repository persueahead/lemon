package com.bjlemon.ssm.web.controller;

import com.bjlemon.ssm.domain.Department;
import com.bjlemon.ssm.service.DepartmentService;
import com.bjlemon.ssm.vo.DepartmentQueryVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentController.java
 * @Description TODO
 * @createTime 2019年12月31日 22:28:00
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public String add(@RequestBody Department department) {
        this.departmentService.addDepartment(department);
        return "success";
    }

    @GetMapping("/department")
    public List<Department> findAll() {
        return this.departmentService.findAll();
    }

    @GetMapping("/department/{pageNum}/{pageSize}")
    public PageInfo<Department> findPagination(@PathVariable Integer pageNum,
                                               @PathVariable Integer pageSize,
                                               @RequestBody DepartmentQueryVO departmentQueryVO) {
        return this.departmentService.findPaginationList(pageNum, pageSize, departmentQueryVO);
    }

}
