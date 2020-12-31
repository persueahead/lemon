package com.bjlemon.jpa.service.impl;

import com.bjlemon.jpa.domain.Department;
import com.bjlemon.jpa.domain.User;
import com.bjlemon.jpa.repository.UserRepository;
import com.bjlemon.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findUserListByName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("");
        }

        return this.userRepository.searchUsersByName(name);
    }

    @Override
    public User authenticate(String name, String password) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("");
        }

        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("");
        }

//        return this.userRepository.findUserByNameAndPassword(name,password);
        return this.userRepository.findUserByNameAndPassword2(name, password);
    }

    @Override
    public Department findDepartmentByUserName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("");
        }

//        return this.userRepository.findDepartmentByUserName(name);

//        User user = this.userRepository.findByName(name);
//        return user.getDepartment();


        User user = this.userRepository.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                Path<String> namePath = root.get("name");

                // 构建条件
                // Predicate断言（谓词 条件）
                Predicate predicate = criteriaBuilder.equal(namePath, name);
                return predicate;
            }
        }).get();

        return user.getDepartment();
    }

    @Override
    public List<User> findUserListByNameAndSalaryScope(String name, List<Float> salaryScopeList) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("");
        }

        if (CollectionUtils.isEmpty(salaryScopeList)) {
            throw new IllegalArgumentException("");
        }

        if (salaryScopeList.size() != 2) {
            throw new IllegalArgumentException("");
        }

        Float beginSalary = salaryScopeList.get(0);
        Float endSalary = salaryScopeList.get(1);

        List<User> userList = this.userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<String> namePath = root.get("name");
                Predicate likePredicate = criteriaBuilder.like(namePath, "%" + name + "%");

                Path<Float> salaryPath = root.get("salary");
                Predicate betweenPredicate = criteriaBuilder.between(salaryPath, beginSalary, endSalary);

                return criteriaBuilder.and(likePredicate, betweenPredicate);
            }
        });

        return userList;
    }

    @Override
    public Department findDepartmentByUserName1(String userName, String departmentName) {
        Optional<User> optional = this.userRepository.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<User, Department> departmentJoin = root.join("department", JoinType.LEFT);
                Path<String> departmentNamePath = departmentJoin.get("name");
                Predicate predicate1 = criteriaBuilder.like(departmentNamePath, departmentName);

                Path<String> namePath = root.get("name");
                Predicate predicate2 = criteriaBuilder.equal(namePath, userName);

                return criteriaBuilder.and(predicate1, predicate2);
            }

            ;
        });

        User user = optional.get();
        return user.getDepartment();
    }
}