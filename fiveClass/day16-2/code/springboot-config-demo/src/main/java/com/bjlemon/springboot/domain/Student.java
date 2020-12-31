package com.bjlemon.springboot.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@ConfigurationProperties(prefix = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = -1640380417365494600L;

    private String[] inters;
}
