package com.bjlemon.springboott.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 493843245297528359L;
    private Integer id;
    private String name;
    private String password;
    private Float salary;
    private Date birthday;
}
