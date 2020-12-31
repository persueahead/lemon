package com.bjlemon.mybatis.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年02月29日 22:19:00
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 8527322364369347165L;

    private Integer id;
    private String name;
    private String password;
    private Float salary;
    private Date birthday;

}
