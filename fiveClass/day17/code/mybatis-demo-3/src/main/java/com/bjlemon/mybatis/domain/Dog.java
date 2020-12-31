package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Dog.java
 * @Description TODO
 * @createTime 2019年12月28日 21:25:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog extends Animal {

    private String furColor;

    @Override
    public String toString() {
        return super.toString() + " Dlog{" +
                "furColor='" + furColor + '\'' +
                '}';
    }
}
