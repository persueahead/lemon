package com.bjlemon.security.dao;

import com.bjlemon.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByName(String name);
}
