package com.bjlemon.mybatis.domain;

import java.io.Serializable;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName TeacherStudent.java
 * @Description TODO
 * @createTime 2020年03月05日 21:21:00
 */
public class TeacherStudent implements Serializable {

    private static final long serialVersionUID = 1577109694452564587L;
    private Teacher teacher;
    private Student student;
}
