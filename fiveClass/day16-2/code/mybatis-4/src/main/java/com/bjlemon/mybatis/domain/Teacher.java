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
 * @ClassName Teacher.java
 * @Description TODO
 * @createTime 2020年03月05日 20:48:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher implements Serializable {

    private static final long serialVersionUID = -9085299453277590840L;
    private Integer id;
    private String name;
    private Float salary;

    private Set<Student> students = new HashSet<>();

}
