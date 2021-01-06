package com;


import com.bjlemon.mp.beans.Employee;
import com.bjlemon.mp.mapper.EmployeeMapper;
import com.bjlemon.mp.service.EmployeeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    static  ClassPathXmlApplicationContext  ioc=null;
    static{
        ioc = new ClassPathXmlApplicationContext("application.xml");
    }


    @Test
    public void testInsert(){

/*        EmployeeMapper employeeMapper=  ioc.getBean(EmployeeMapper.class);
        Employee emp =new Employee();
        emp.setEmpName("admin");
        emp.setEmpJob("销售");
        employeeMapper.insert(emp);*/


      EmployeeService service= ioc.getBean(EmployeeService.class);
        Employee emp =new Employee();
        emp.setEmpName("admin");
        emp.setEmpJob("销售");
        emp.setEmpSalary( new BigDecimal(998));

        boolean isok=service.save(emp);

        System.out.println(isok);


    }

    @Test
    public  void testOptimisticLocker(){
        EmployeeService service= ioc.getBean(EmployeeService.class);
        Employee employee = new Employee();
        employee.setId(4);
        employee.setEmpName("jack");
        employee.setVersion(2);

        boolean isOk= service.updateById(employee);
        System.out.println(isOk);

    }

    @Test
    public void testLogicDelete(){
        EmployeeService service= ioc.getBean(EmployeeService.class);
        Employee employee = new Employee();
       boolean isOk= service.removeById(5);
        System.out.println(isOk);

    }




}
