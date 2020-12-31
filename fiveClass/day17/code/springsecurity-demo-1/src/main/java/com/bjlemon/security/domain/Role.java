package com.bjlemon.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Role.java
 * @Description TODO
 * @createTime 2020年02月11日 22:15:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role implements Serializable {

    private static final long serialVersionUID = -5052171480048519655L;
    private Integer id;
    private String name;

}
