package com.bjlemon.springboot.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Person.java
 * @Description TODO
 * @createTime 2020年01月09日 20:52:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Person implements Serializable {

    private static final long serialVersionUID = -7781363758228225226L;
    private Integer id;
    private String name;
    private String password;
    private Float salary;
    private Date birthday;
}
