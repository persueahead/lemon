package com.bjlemon.springboot.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年01月02日 22:31:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = -6048472400496098620L;
    private Integer id;
    private String name;
    private String password;
    private Double salary;
    private Date birthday;
}
