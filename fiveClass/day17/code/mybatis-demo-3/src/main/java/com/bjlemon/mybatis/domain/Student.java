package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Student.java
 * @Description TODO
 * @createTime 2019年12月28日 20:07:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = 5516784836720369956L;
    private Integer id;
    private String name;

    private Set<Teacher> teachers = new HashSet<>();

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
