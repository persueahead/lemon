package com.bjlemon.mybatis.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Student.java
 * @Description TODO
 * @createTime 2020年03月05日 20:48:00
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 5516784836720369956L;
    private Integer id;
    private String name;
    private Float score;

    private Set<Teacher> teachers = new HashSet<>();

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
