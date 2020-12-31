package com.bjlemon.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = -1910469402251704777L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id", length = 4)
    private Integer id;

    @Column(name = "permission_name", length = 20, nullable = false)
    private String name;

    @Column(name = "permission_code", length = 20, nullable = false)
    private String code;

    @Column(name = "permissionn_url", length = 20, nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Permission parent;

    @OneToMany(mappedBy = "parent")
    private Set<Permission> children;

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
