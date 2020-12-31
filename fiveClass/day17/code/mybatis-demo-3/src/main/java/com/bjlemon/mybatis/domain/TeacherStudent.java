package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName TeacherStudent.java
 * @Description TODO
 * @createTime 2019年12月28日 20:52:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherStudent implements Serializable {

    private static final long serialVersionUID = 1577109694452564587L;
    private Integer id;
    private Teacher teacher;
    private Student student;

}
