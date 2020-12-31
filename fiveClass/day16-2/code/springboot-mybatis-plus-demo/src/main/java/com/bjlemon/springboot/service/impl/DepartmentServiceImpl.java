package com.bjlemon.springboot.service.impl;

import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.mapper.DepartmentMapper;
import com.bjlemon.springboot.service.DepartmentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public Department findDepartmentByName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("");
        }

        /*QueryWrapper<Department> wrapper = new QueryWrapper<>();
        wrapper.eq("department_name",name);

        // TODO
        return this.departmentMapper.selectOne(wrapper);*/

        return this.departmentMapper.findByName(name);
    }

    @Override
    public Department findDepartmentByName1(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("");
        }

        return this.departmentMapper.findByName1(name);
    }
}
