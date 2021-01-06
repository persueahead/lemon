package com.example.ln.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ln.po.UserInfo;

public interface UserInfoDAO extends JpaRepository<UserInfo, Integer> {

}
