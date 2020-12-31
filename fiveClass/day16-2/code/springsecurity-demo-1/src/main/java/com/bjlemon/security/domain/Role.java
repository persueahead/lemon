package com.bjlemon.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_role")
public class Role implements Serializable {

    private static final long serialVersionUID = -5052171480048519655L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", length = 4)
    private Integer id;

    @Column(name = "role_name", length = 20, nullable = false)
    private String name;

}
