package com.bjlemon.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -6048472400496098620L;
    private Integer id;
    private String name;
    private String password;
    private Float salary;
    private Date birthday;
}
