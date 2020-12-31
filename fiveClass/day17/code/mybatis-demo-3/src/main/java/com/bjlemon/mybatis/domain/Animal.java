package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Animal.java
 * @Description TODO
 * @createTime 2019年12月28日 21:23:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Animal implements Serializable {

    private static final long serialVersionUID = -850388713185770583L;
    private Integer id;
    private String name;
}
