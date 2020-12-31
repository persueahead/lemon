package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Department.java
 * @Description TODO
 * @createTime 2020年03月03日 21:42:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department implements Serializable {

    private static final long serialVersionUID = -2060603187050196155L;
    private Integer id;
    private String name;
    private String location;

    private Set<Employee> employees = new HashSet<>();

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}