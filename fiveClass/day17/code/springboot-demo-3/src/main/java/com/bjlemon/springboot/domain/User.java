package com.bjlemon.springboot.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Person.java
 * @Description TODO
 * @createTime 2020年01月04日 20:44:00
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 7221273092035730298L;

    private String name;
    private Integer age;
    //    private String[] inters;
    private List<String> inters;

}
