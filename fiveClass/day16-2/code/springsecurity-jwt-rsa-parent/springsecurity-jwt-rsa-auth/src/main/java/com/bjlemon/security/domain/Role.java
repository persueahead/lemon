package com.bjlemon.security.domain;

import java.io.Serializable;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Role.java
 * @Description TODO
 * @createTime 2020年02月20日 21:02:00
 */
public class Role implements Serializable {

    private static final long serialVersionUID = -5052171480048519655L;

    private Integer id;
    private String name;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
