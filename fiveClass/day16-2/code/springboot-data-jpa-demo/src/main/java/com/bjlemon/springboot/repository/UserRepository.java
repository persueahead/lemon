package com.bjlemon.springboot.repository;

import com.bjlemon.springboot.domain.Department;
import com.bjlemon.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

//    List<User> findByName(String name);

    User findByName(String name);

//    List<User> getByName(String name);

//    List<User> findUsersByNameEquals(String name);

    @Query("from User u where u.name = ?1")
    List<User> searchUsersByName(String name);

    User findUserByNameAndPassword(String name, String password);

    @Query("select u from User u where u.name = ?1 and u.password = ?2")
    User findUserByNameAndPassword1(String name, String password);

    @Query(value = "select " +
            "* " +
            " from " +
            " t_user " +
            "where user_name = ? and user_password = ?", nativeQuery = true)
    User findUserByNameAndPassword2(String name, String password);

    @Query("select d from User u left join u.department d where u.name = ?1")
    Department findDepartmentByUserName(String name);
}