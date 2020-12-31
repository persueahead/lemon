package com.bjlemon.springboot.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年01月07日 22:46:00
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private Float salary;
    private Date birthday;
}
