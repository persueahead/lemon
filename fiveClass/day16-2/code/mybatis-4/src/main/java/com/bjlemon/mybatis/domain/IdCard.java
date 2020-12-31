package com.bjlemon.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName IdCard.java
 * @Description TODO
 * @createTime 2020年03月03日 21:42:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdCard implements Serializable {

    private static final long serialVersionUID = -2060603187050196155L;
    private Integer id;
    private String number;
    private Person person;

    @Override
    public String toString() {
        return "IdCard{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
