package com.department.manager.service.impl;

import com.department.manager.domain.Department;
import com.department.manager.domain.DepartmentExample;
import com.department.manager.mapper.DepartmentMapper;
import com.department.manager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public int addDepartment(Department department) {
        return this.departmentMapper.insertSelective(department);
    }

    @Override
    public List<Department> allDepartmentList() {
        DepartmentExample departmentExample = new DepartmentExample();
        return this.departmentMapper.selectByExample(departmentExample);
    }

    @Override
    public int modifyDepartment(Department department) {
        return this.departmentMapper.updateByPrimaryKeySelective(department);
    }

    @Override
    public int deleteDepartmentById(int[] ids) {
        int i = 0;
        for (int id : ids) {
            Department departmen = new Department();
            departmen.setDepId(id);
            departmen.setDepState(1);
//            修改state为1
            i = this.departmentMapper.updateByPrimaryKeySelective(departmen);
        }
        return i;
    }

    @Override
    public Department selectByDepartmentName(String depName) {
        Department department=null;
        DepartmentExample departmentExample=new DepartmentExample();
        DepartmentExample.Criteria criteria=departmentExample.createCriteria();
        criteria.andDepNameEqualTo(depName);
        try{
            department=this.departmentMapper.selectByExample(departmentExample).get(0);
        }catch(Exception e){
            department=new Department();
        }

        return  department;
    }

    @Override
    public Department selectByDepartmentId(int depId) {
        return this.departmentMapper.selectByPrimaryKey(depId);
    }

    @Override
    public void rebuildBaseDepartment(List<Department> baseDepartment, Model model) {
//        查所有部门，覆盖baseDepartment值
        baseDepartment= this.allDepartmentList();
//        覆盖
        model.addAttribute("baseDepartment",baseDepartment);
    }
}
