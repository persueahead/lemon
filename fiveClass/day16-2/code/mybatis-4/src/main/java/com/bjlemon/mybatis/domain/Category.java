package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Category.java
 * @Description TODO
 * @createTime 2020年03月05日 21:24:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category implements Serializable {

    private static final long serialVersionUID = 7925405869126298028L;
    private Integer id;
    private String name;

    // 父类别
    /**
     * @many-to-one
     */
    private Category parent;

    /**
     * @one-to-many
     */
    private Set<Category> children;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
