package com.bjlemon.mp.mapper;

import com.bjlemon.mp.beans.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bjlemon
 * @since 2018-12-17
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    public  boolean deleteByName(String  name) throws Exception;



}
