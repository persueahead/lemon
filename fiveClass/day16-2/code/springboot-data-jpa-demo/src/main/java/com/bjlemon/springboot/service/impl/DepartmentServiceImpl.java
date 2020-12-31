package com.bjlemon.springboot.service.impl;

import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.domain.User;
import com.bjlemon.springboot.repository.DepartmentRepository;
import com.bjlemon.springboot.repository.UserRepository;
import com.bjlemon.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("");
        }

        this.departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("");
        }

        Set<User> users = department.getUsers();
        if (CollectionUtils.isEmpty(users)) {
            this.departmentRepository.delete(department);
        } else {
            throw new RuntimeException("部门下有用户，不能删除!");
        }

    }

    @Override
    public void modifyDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("");
        }

        this.departmentRepository.saveAndFlush(department);
    }

    @Override
    public Department findDepartmentById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("");
        }

        return this.departmentRepository.findById(id).get();
    }

    @Override
    public List<Department> findAllDepartmentList() {
        return this.departmentRepository.findAll();
    }

    @Override
    public List<User> findAllUserListByDepartmentName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("");
        }

        return this.departmentRepository.findUsersByDepartmentName(name);


       /* Department department = this.departmentRepository.findDepartmentByName(name);
        return new ArrayList<>(department.getUsers());*/
    }
}
