package com.bjlemon.jpa.service;

import com.bjlemon.jpa.domain.Department;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentService.java
 * @Description TODO
 * @createTime 2020年01月14日 22:49:00
 */
public interface DepartmentService {

    Department findDepartmentByUserName(String name);

}
