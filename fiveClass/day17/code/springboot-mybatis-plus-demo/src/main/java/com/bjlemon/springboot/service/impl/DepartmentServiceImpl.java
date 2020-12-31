package com.bjlemon.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.domain.User;
import com.bjlemon.springboot.mapper.DepartmentMapper;
import com.bjlemon.springboot.mapper.UserMapper;
import com.bjlemon.springboot.service.DepartmentService;
import com.bjlemon.springboot.vo.DepartmentQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentServiceImpl.java
 * @Description TODO
 * @createTime 2020年01月12日 21:44:00
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addDepartment(Department department) {
        this.departmentMapper.insert(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        // TODO 根据部门id查询用户
        Integer departmentId = department.getId();
        List<User> userList = this.userMapper.findUsersByDepartmentId(departmentId);
        if (!CollectionUtils.isEmpty(userList)) {
            throw new RuntimeException("部门下有员工，不能删除!");
        }

        this.departmentMapper.deleteById(departmentId);
    }

    @Override
    public void modifyDepartment(Department department) {
        this.departmentMapper.updateById(department);
    }

    @Override
    public Department findDepartmentById(Integer id) {
        return this.departmentMapper.selectById(id);
    }

    @Override
    public List<Department> findAllDepartmentList() {
        return this.departmentMapper.selectList(null);
    }

    @Override
    public List<Department> findDepartmentListByQueryVO(DepartmentQueryVO departmentQueryVO) {
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
        if (departmentQueryVO == null) {
            return this.findAllDepartmentList();
        }
        String name = departmentQueryVO.getName();
        String location = departmentQueryVO.getLocation();

        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("department_name", "%" + name + "%");
        }

        if (!StringUtils.isEmpty(location)) {
            queryWrapper.like("department_location", "%" + location + "%");
        }

        return departmentMapper.selectList(queryWrapper);
    }

    @Override
    public Page<Department> findDepartmentPaginationList(Integer pageNum, Integer pageSize) {
        Page<Department> page = new Page<>(pageNum, pageSize);
        page = (Page<Department>) this.departmentMapper.selectPage(page, null);
        return page;
    }
}


