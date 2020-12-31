package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Animal.java
 * @Description TODO
 * @createTime 2020年03月05日 21:43:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Animal implements Serializable {

    private static final long serialVersionUID = -850388713185770583L;
    private Integer id;
    private String name;

}
