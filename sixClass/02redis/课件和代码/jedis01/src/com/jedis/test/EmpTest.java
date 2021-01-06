package com.jedis.test;

import com.jedis.po.Dept;
import com.jedis.po.EmpInfo;
import com.jedis.utils.RedisUtil;

import redis.clients.jedis.Jedis;

public class EmpTest {

	
	public static void main(String[] args) {
		//查询所有的部门信息
				Jedis jedis = RedisUtil.getJedis();
					
				EmpInfo emp = new EmpInfo();
				emp.setEmpId(jedis.hget("emp:1001", "emp_id"));
				emp.setEmpName(jedis.hget("emp:1001", "emp_name"));
				emp.setEmpAge(jedis.hget("emp:1001", "emp-age"));
				emp.setEmpSex(jedis.hget("emp:1001", "emp_sex"));
			
				//System.out.println(emp);
				
				//部门编号
				String deId = jedis.hget("emp:1001", "de_id");
				
				Dept de = new Dept();
				de.setDeId(Integer.parseInt(jedis.hget("dept:"+deId, "de_id")));
				de.setDeName(jedis.hget("dept:"+deId, "de_name"));
				
				emp.setDept(de);
				
				System.out.println(emp);
				
				
				jedis.close();
	}
}
