package com.bjlemon.security.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年02月20日 21:01:00
 */
public class User implements Serializable {

    private static final long serialVersionUID = -8404801486370726870L;
    private Integer id;
    private String name;
    private String password;
    private Integer status;
    private List<Role> roles = new ArrayList<>();

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
