package com.bjlemon.mp.service.impl;

import com.bjlemon.mp.beans.Employee;
import com.bjlemon.mp.mapper.EmployeeMapper;
import com.bjlemon.mp.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bjlemon
 * @since 2018-12-17
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
