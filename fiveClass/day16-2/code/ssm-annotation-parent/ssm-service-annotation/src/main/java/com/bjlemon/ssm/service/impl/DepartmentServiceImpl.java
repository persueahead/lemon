package com.bjlemon.ssm.service.impl;

import com.bjlemon.ssm.domain.Department;
import com.bjlemon.ssm.domain.DepartmentExample;
import com.bjlemon.ssm.domain.Employee;
import com.bjlemon.ssm.domain.EmployeeExample;
import com.bjlemon.ssm.exception.SsmException;
import com.bjlemon.ssm.mapper.DepartmentMapper;
import com.bjlemon.ssm.mapper.EmployeeMapper;
import com.bjlemon.ssm.service.DepartmentService;
import com.bjlemon.ssm.vo.DepartmentQueryVO;
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
 * @createTime 2020年03月07日 22:55:00
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public void addDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("");
        }

        this.departmentMapper.insertSelective(department);
    }

    public void deleteDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("");
        }

        Integer departmentId = department.getDepartmentId();
        List<Employee> employeeList = this.findEmployeeListByDepartmentId(departmentId);
        if (CollectionUtils.isEmpty(employeeList)) {
            this.departmentMapper.deleteByPrimaryKey(departmentId);
        } else {
            throw new SsmException("该部门有员工，不能删除");
        }

    }

    public void modifyDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("");
        }

        this.departmentMapper.updateByPrimaryKeySelective(department);
    }

    public Department findDepartmentById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("");
        }

        return this.departmentMapper.selectByPrimaryKey(id);
    }

    public List<Department> findAllDepartmentList() {
        /*DepartmentExample departmentExample = new DepartmentExample();
        return this.departmentMapper.selectByExample(departmentExample);*/

        return this.departmentMapper.selectByExample(null);
    }

    public List<Department> findDepartmentListByQueryVO(DepartmentQueryVO departmentQueryVO) {
        if (departmentQueryVO == null) {
            return this.findAllDepartmentList();
        }

        String name = departmentQueryVO.getDepartmentName();
        String location = departmentQueryVO.getDepartmentLocation();

        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();

        if (StringUtils.isNoneBlank(name)) {
            criteria.andDepartmentNameLike("%" + name + "%");
        }

        if (StringUtils.isNoneBlank(location)) {
            criteria.andDepartmentLocationLike("%" + location + "%");
        }

        return this.departmentMapper.selectByExample(departmentExample);
    }

    public List<Employee> findEmployeeListByDepartmentId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("");
        }

        // 使用DepartmentExample
        EmployeeExample employeeExample = new EmployeeExample();
        // 基于标准查询（条件）
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andDepartmentIdEqualTo(id);

        return this.employeeMapper.selectByExample(employeeExample);
    }

    public PageInfo<Department> findDepartemntPaginationList(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum <= 0) {
            throw new IllegalArgumentException("");
        }

        if (pageSize == null || pageSize <= 0) {
            throw new IllegalArgumentException("");
        }

        // 真正查询之前写上下面这行代码就意味着可以进行分页查询
        PageHelper.startPage(pageNum, pageSize);

        List<Department> departmentList = this.departmentMapper.selectByExample(null);
        PageInfo<Department> pageInfo = new PageInfo<Department>(departmentList);

        return pageInfo;
    }

    public PageInfo<Department> findDepartemntPaginationListByQueryVO(Integer pageNum, Integer pageSize, DepartmentQueryVO departmentQueryVO) {
        if (pageNum == null || pageNum <= 0) {
            throw new IllegalArgumentException("");
        }

        if (pageSize == null || pageSize <= 0) {
            throw new IllegalArgumentException("");
        }

        if (departmentQueryVO == null) {
            this.findDepartemntPaginationList(pageNum, pageSize);
        }

        // 真正查询之前写上下面这行代码就意味着可以进行分页查询
        PageHelper.startPage(pageNum, pageSize);

        String name = departmentQueryVO.getDepartmentName();
        String location = departmentQueryVO.getDepartmentLocation();

        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();

        if (StringUtils.isNoneBlank(name)) {
            criteria.andDepartmentNameLike("%" + name + "%");
        }

        if (StringUtils.isNoneBlank(location)) {
            criteria.andDepartmentLocationLike("%" + location + "%");
        }

        List<Department> departmentList = this.departmentMapper.selectByExample(departmentExample);
        PageInfo<Department> pageInfo = new PageInfo<Department>(departmentList);

        return pageInfo;
    }
}
