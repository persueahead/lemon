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
 * @createTime 2019年12月26日 22:55:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdCard implements Serializable {

    private static final long serialVersionUID = 6498907320091189968L;
    private Integer id;
    private String idCardNumber;

    private Person person;

    @Override
    public String toString() {
        return "IdCard{" +
                "id=" + id +
                ", idCardNumber='" + idCardNumber + '\'' +
                '}';
    }
}
