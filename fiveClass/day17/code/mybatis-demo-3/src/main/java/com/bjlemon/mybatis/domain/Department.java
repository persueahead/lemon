package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Department.java
 * @Description TODO
 * @createTime 2019年12月26日 21:13:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department implements Serializable {

    private static final long serialVersionUID = -2060603187050196155L;
    private Integer id;
    private String name;
    private String location;

    private Set<Employee> employees;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
