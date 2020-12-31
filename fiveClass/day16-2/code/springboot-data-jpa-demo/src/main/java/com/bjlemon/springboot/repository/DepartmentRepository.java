package com.bjlemon.springboot.repository;

import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor {

    Department findDepartmentByName(String name);

    @Query("select u from Department d left join d.users u where d.name = ?1")
    List<User> findUsersByDepartmentName(String name);
}
