package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Person.java
 * @Description TODO
 * @createTime 2019年12月26日 22:55:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Serializable {

    private static final long serialVersionUID = -5808272300904340367L;
    private Integer id;
    private String name;

    private IdCard idCard;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
