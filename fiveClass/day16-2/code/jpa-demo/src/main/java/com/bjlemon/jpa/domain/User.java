package com.bjlemon.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jpa_user")
public class User implements Serializable {

    private static final long serialVersionUID = 2173963537830426270L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",length = 4)
    private Integer id;

    @Column(name = "user_name",length = 20,nullable = false)
    private String name;

    @Column(name = "user_password",length = 20,nullable = false)
    private String password;

    @Column(name = "user_salary",length = 6,precision = 2,nullable = false)
    private Float salary;

    @Column(name = "user_birthday",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;
}
