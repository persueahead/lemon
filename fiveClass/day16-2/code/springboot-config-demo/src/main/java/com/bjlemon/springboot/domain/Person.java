package com.bjlemon.springboot.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

    private static final long serialVersionUID = -6048472400496098620L;

    private String username;
    private String password;
    private String info;
}
