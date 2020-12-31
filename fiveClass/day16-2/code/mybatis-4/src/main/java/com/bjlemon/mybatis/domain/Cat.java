package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Cat.java
 * @Description TODO
 * @createTime 2020年03月05日 21:44:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat extends Animal {

    private String eyeColor;

    @Override
    public String toString() {
        return super.toString() + "Cat{" +
                "eyeColor='" + eyeColor + '\'' +
                '}';
    }
}
