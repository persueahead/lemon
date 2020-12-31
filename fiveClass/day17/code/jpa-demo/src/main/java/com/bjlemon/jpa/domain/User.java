package com.bjlemon.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年01月14日 20:59:00
 */
@Data
@Entity
@Table(name = "jpa_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1888819090828579238L;

    @Id
    // 主键生成策略。其中strategy注解的属性，该属性如果不指定值那么就会使用默认值（AUTO）
    // 根据底层数据库自动选择主键生成策略
    // 当前数据库是mysql数据库，又由于id是整型，因此建表时会将其字段做成自动增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", length = 4)
    private Integer id;

    @Column(name = "user_name", length = 20, nullable = false)
    private String name;

    @Column(name = "user_password", length = 20, nullable = false)
    private String password;

    @Column(name = "user_salary", length = 6, precision = 2, nullable = false)
    private Float salary;

    @Column(name = "user_birthday", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;
}
