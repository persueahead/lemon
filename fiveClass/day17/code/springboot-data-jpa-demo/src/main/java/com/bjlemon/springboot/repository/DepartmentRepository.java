package com.bjlemon.springboot.repository;

import com.bjlemon.springboot.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentRepository.java
 * @Description TODO
 * @createTime 2020年01月14日 22:48:00
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {


}
