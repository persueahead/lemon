package com.bjlemon.jpa.service.impl;

import com.bjlemon.jpa.domain.Department;
import com.bjlemon.jpa.domain.User;
import com.bjlemon.jpa.repository.DepartmentRepository;
import com.bjlemon.jpa.service.DepartmentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName DepartmentServiceImpl.java
 * @Description TODO
 * @createTime 2020年01月14日 22:50:00
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department findDepartmentByUserName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("");
        }

        return this.departmentRepository.findOne(new Specification<Department>() {
            @Override
            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<Department, User> join = root.join("users", JoinType.LEFT);
                Expression<String> nameExpression = join.get("name").as(String.class);
                return criteriaBuilder.equal(nameExpression, name);
            }
        }).get();
    }
}
