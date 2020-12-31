package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Category.java
 * @Description TODO
 * @createTime 2019年12月28日 21:14:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

    private static final long serialVersionUID = 7925405869126298028L;
    private Integer id;
    private String name;
    private Category parent;
    private Set<Category> children;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
