package com.bjlemon.mybatis.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 8527322364369347165L;
    private Integer id;
    private String name;
    private String password;
    private Float salary;
    private Date birthday;

}
