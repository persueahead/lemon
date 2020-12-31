package com.bjlemon.ssm.service.impl;

import com.bjlemon.ssm.domain.Department;
import com.bjlemon.ssm.domain.DepartmentExample;
import com.bjlemon.ssm.mapper.DepartmentMapper;
import com.bjlemon.ssm.service.DepartmentService;
import com.bjlemon.ssm.vo.DepartmentQueryVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @createTime 2019年12月31日 22:19:00
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public PageInfo<Department> findPaginationList(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum <= 0) {
            throw new IllegalArgumentException("");
        }

        if (pageSize == null || pageSize <= 0) {
            throw new IllegalArgumentException("");
        }

        // 开始分页
        PageHelper.startPage(pageNum, pageSize);

        DepartmentExample departmentExample = new DepartmentExample();
        List<Department> departmentList = this.departmentMapper.selectByExample(departmentExample);

        return new PageInfo<Department>(departmentList);
    }

    public void addDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("");
        }

        this.departmentMapper.insertSelective(department);
    }

    public List<Department> findAll() {
        DepartmentExample departmentExample = new DepartmentExample();
        List<Department> departmentList = this.departmentMapper.selectByExample(departmentExample);
        return departmentList;
    }

    public PageInfo<Department> findPaginationList(Integer pageNum, Integer pageSize, DepartmentQueryVO departmentQueryVO) {
        if (departmentQueryVO == null) {
            return this.findPaginationList(pageNum, pageSize);
        }

        String departmentName = departmentQueryVO.getDepartmentName();
        String departmentLocation = departmentQueryVO.getDepartmentLocation();

        PageHelper.startPage(pageNum, pageSize);
        DepartmentExample departmentExample = new DepartmentExample();

        DepartmentExample.Criteria criteria = departmentExample.createCriteria();

        if (StringUtils.isNotBlank(departmentName)) {
            criteria.andDepartmentNameLike("%" + departmentName + "%");
        }

        if (StringUtils.isNotBlank(departmentLocation)) {
            criteria.andDepartmentLocationLike("%" + departmentLocation + "%");
        }

        List<Department> departmentList = this.departmentMapper.selectByExample(departmentExample);
        return new PageInfo<Department>(departmentList);

    }
}
