package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Dog.java
 * @Description TODO
 * @createTime 2020年03月05日 21:44:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog extends Animal {

    private String furColor;

    @Override
    public String toString() {
        return super.toString() + " Dog{" +
                "furColor='" + furColor + '\'' +
                '}';
    }
}
