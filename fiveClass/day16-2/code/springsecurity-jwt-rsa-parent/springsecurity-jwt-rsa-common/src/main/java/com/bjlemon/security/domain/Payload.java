package com.bjlemon.security.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Payload.java
 * @Description TODO
 * @createTime 2020年02月20日 20:45:00
 */
@Data
public class Payload<T> implements Serializable {

    private static final long serialVersionUID = 3159900494639183273L;
    private String id;
    private T userInfo;
    private Date expiration;
}
