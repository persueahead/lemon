package com.bjlemon.jpa.service.impl;

import com.bjlemon.jpa.domain.Department;
import com.bjlemon.jpa.domain.User;
import com.bjlemon.jpa.repository.UserRepository;
import com.bjlemon.jpa.service.UserService;
import com.bjlemon.jpa.vo.UserQueryVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年01月14日 22:50:00
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        this.userRepository.save(user);

    }

    @Override
    public void deleteUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        this.userRepository.delete(user);
    }

    @Override
    public void modifyUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("");
        }

        // 相当于HIbernate框架中的saveOrUpdate()
        this.userRepository.save(user);
    }

    @Override
    public User findUserById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("");
        }

//        return this.userRepository.getOne(id);
        return this.userRepository.findById(id).get();
    }

    @Override
    public List<User> findAllUserList() {
        return this.userRepository.findAll();
    }

    @Override
    public Page<User> findUserPaginationList(PageRequest pageRequest) {
        if (pageRequest == null) {
            throw new IllegalArgumentException("");
        }

        return this.userRepository.findAll(pageRequest);
    }

    @Override
    public Page<User> findUserPaginationList(PageRequest pageRequest, UserQueryVO userQueryVO) {
        List<Predicate> predicateList = new ArrayList<>();

        if (pageRequest == null) {
            throw new IllegalArgumentException("");
        }

        // 没有条件的分页查询
        if (userQueryVO == null) {
            return this.findUserPaginationList(pageRequest);
        }

        String name = userQueryVO.getName();
        String password = userQueryVO.getPassword();
        Float salary = userQueryVO.getSalary();
        Date birthday = userQueryVO.getBirthday();

        return this.userRepository.findAll(new Specification<User>() {


            /**
             * @title findUserPaginationList
             * @description
             * @author admin
             * @updateTime 2020/1/16 20:49 org.springframework.data.domain.Page<com.bjlemon.jpa.domain.User>
             * @param root：以哪一个对象为基准对象来查询
             * @param query：查询对象。此种查询称为：QBC（基于标准化查询）
             * @param criteriaBuilder：条件构建器。
             */
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate namePredicate = null;
                if (StringUtils.isNotBlank(name)) {
                    Path<String> namePath = root.get("name");
                    namePredicate = criteriaBuilder.like(namePath, "%" + name + "%");
                    predicateList.add(namePredicate);
                }

                Predicate passwordPredicate = null;
                if (StringUtils.isNotBlank(password)) {
                    Path<String> passwordPath = root.get("password");
                    passwordPredicate = criteriaBuilder.like(passwordPath, "%" + password + "%");
                    predicateList.add(passwordPredicate);
                }

                Predicate salaryPredicate = null;
                if (salary != null) {
                    Path<Float> salaryPath = root.get("salary");
                    salaryPredicate = criteriaBuilder.equal(salaryPath, salary);
                    predicateList.add(salaryPredicate);
                }

                Predicate birthdayPredicate = null;
                if (birthday != null) {
                    Path<Date> birthdayPath = root.get("birthday");
                    birthdayPredicate = criteriaBuilder.equal(birthdayPath, birthday);
                    predicateList.add(birthdayPredicate);
                }

                Predicate[] predicates = predicateList.toArray(new Predicate[predicateList.size()]);
                return criteriaBuilder.and(predicates);
            }
        }, pageRequest);
    }

    /*@Override
    public Department findDepartmentByUserName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("");
        }

        User user = this.findUserByName(name);

        if (user != null) {
            return user.getDepartment();
        }

        return null;

    }*/

    /*@Override
    public Department findDepartmentByUserName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("");
        }

        User user = this.userRepository.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Expression<String> nameExpression = root.get("name").as(String.class);
                return criteriaBuilder.equal(nameExpression, name);
            }
        }).get();

        if (user != null) {
            return user.getDepartment();
        }

        return null;
    }*/

    @Override
    public Department findDepartmentByUserName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("");
        }

        User user = this.userRepository.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<User, Department> join = root.join("department", JoinType.LEFT);
                Expression<String> expression = join.get("users").get("name").as(String.class);
                return criteriaBuilder.equal(expression, name);
            }
        }).get();

        if (user != null) {
            return user.getDepartment();
        }

        return null;
    }

    @Override
    public User findUserByName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("");
        }

        return this.userRepository.findUsersByNameEquals(name);
    }

    @Override
    public List<User> findUserListByName(String name) {
        return this.userRepository.findUsersByName(name);
    }

    @Override
    public List<User> findUserListByNameAndSalary(String name, Float salary) {
        return this.userRepository.findUsersByNameAndSalary(name, salary);
    }

    @Override
    public List<User> findUserListByNameAndSalary1(String name, Float salary) {
        return this.userRepository.findUsersByNameAndSalary1(name, salary);
    }
}
