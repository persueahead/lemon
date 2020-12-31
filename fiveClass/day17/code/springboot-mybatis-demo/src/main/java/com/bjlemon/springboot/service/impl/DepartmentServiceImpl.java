package com.bjlemon.springboot.service.impl;

import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.domain.DepartmentExample;
import com.bjlemon.springboot.domain.User;
import com.bjlemon.springboot.mapper.DepartmentMapper;
import com.bjlemon.springboot.mapper.UserMapper;
import com.bjlemon.springboot.service.DepartmentService;
import com.bjlemon.springboot.vo.DepartmentQueryVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentServiceImpl.java
 * @Description TODO
 * @createTime 2020年01月12日 20:08:00
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
        if (department == null) {
            throw new IllegalArgumentException("");
        }

        this.departmentMapper.insertSelective(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("");
        }

        Integer departmentId = department.getDepartmentId();
        List<User> userList = this.userMapper.findUsersByDepartmentId(departmentId);
        if (CollectionUtils.isNotEmpty(userList)) {
            throw new RuntimeException("部门下有员工，不能删除!");
        }

        this.departmentMapper.deleteByPrimaryKey(departmentId);
    }

    @Override
    public void modifyDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("");
        }

        this.departmentMapper.updateByPrimaryKeySelective(department);
    }

    @Override
    public Department findDepartmentById(Integer id) {
        return this.departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Department> findAllDepartmentList() {
        DepartmentExample departmentExample = new DepartmentExample();
        return this.departmentMapper.selectByExample(departmentExample);
    }

    @Override
    public List<Department> findDepartmentListByQueryVO(DepartmentQueryVO departmentQueryVO) {
        DepartmentExample departmentExample = new DepartmentExample();

        if (departmentQueryVO == null) {
            return this.findAllDepartmentList();
        }

        String departmentName = departmentQueryVO.getDepartmentName();
        String departmentLocation = departmentQueryVO.getDepartmentLocation();

        DepartmentExample.Criteria criteria = departmentExample.createCriteria();

        if (StringUtils.isNotBlank(departmentName)) {
            criteria.andDepartmentNameLike("%" + departmentName + "%");
        }

        if (StringUtils.isNotBlank(departmentLocation)) {
            criteria.andDepartmentLocationLike("%" + departmentLocation + "%");
        }

        return this.departmentMapper.selectByExample(departmentExample);
    }

    @Override
    public PageInfo<Department> findDepartmentPaginationList(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum <= 0) {
            throw new IllegalArgumentException("");
        }

        if (pageSize == null || pageSize <= 0) {
            throw new IllegalArgumentException("");
        }

        PageHelper.startPage(pageNum, pageSize);
        DepartmentExample departmentExample = new DepartmentExample();
        List<Department> departmentList = this.departmentMapper.selectByExample(departmentExample);

        return new PageInfo<>(departmentList);
    }
}
