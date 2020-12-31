package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Employee.java
 * @Description TODO
 * @createTime 2020年03月03日 21:43:0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee implements Serializable {

    private static final long serialVersionUID = -6190811029699112651L;
    private Integer id;
    private String name;
    private String password;
    private Float salary;
    private Date birthday;

    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }

}
