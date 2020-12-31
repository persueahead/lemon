package com.bjlemon.security.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年02月11日 22:11:00
 */
@Data
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -8404801486370726870L;

    private Integer id;
    private String name;
    private String password;
    private Float salary;
    private Date birthday;

    private Set<Role> roles = new HashSet<Role>();
}
