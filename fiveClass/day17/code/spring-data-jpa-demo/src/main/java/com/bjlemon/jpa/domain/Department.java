package com.bjlemon.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName Department.java
 * @Description TODO
 * @createTime 2020年01月14日 22:40:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jpa_department")
public class Department implements Serializable {

    private static final long serialVersionUID = -428052927254415765L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", length = 4)
    private Integer id;

    @Column(name = "department_name", length = 20, nullable = false)
    private String name;

    @Column(name = "department_location", length = 50, nullable = false)
    private String location;

    @OneToMany(mappedBy = "department")
    private Set<User> users = new HashSet<>();

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
