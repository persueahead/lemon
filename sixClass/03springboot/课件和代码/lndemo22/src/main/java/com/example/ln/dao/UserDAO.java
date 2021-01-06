package com.example.ln.dao;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ln.po.UserInfo;

public interface UserDAO extends JpaRepository<UserInfo, Integer> {

	/**
	 * 添加或修改用户
	 * key =1001
	 * @CachePut 这个注释可以确保方法被执行，同时方法的返回值也会被记录到缓存中（key="1001"）
	 * 实现缓存和数据库的同步更新
	 */
	@CachePut(cacheNames="liu",key="#p0.userId")
	public UserInfo save(UserInfo user);
	
	/**
	 * 根据编号查询用户信息
	 * @param userId
	 * @return
	 *  @Cacheable 当调用这个方法的时候，会从名叫key="1001"缓存查询，如果没有，就执行实际的方法（查询数据库）,
	 *  并将这个结果存入缓存中，否则返回缓存中的对象
	 */
	@Cacheable(cacheNames="liu",key="#p0")
	public UserInfo findByUserId(Integer userId);
}
