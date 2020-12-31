package com.bjlemon.springboot.repository;

import com.bjlemon.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserRepository.java
 * @Description TODO
 * @createTime 2020年01月14日 22:48:00
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    User findUsersByNameEquals(String name);

    @Query("select u from User u where u.name like ?1")
    List<User> findUsersByName(String name);

    @Query("select u from User u where u.name like ?1 and u.salary = ?2")
    List<User> findUsersByNameAndSalary(String name, Float salary);

    @Query(value = "select * from jpa_user where user_name like ? and user_salary = ?", nativeQuery = true)
    List<User> findUsersByNameAndSalary1(String name, Float salary);

}
