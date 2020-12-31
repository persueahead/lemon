package com.bjlemon.springboot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sm_department")
public class Department implements Serializable {

    private static final long serialVersionUID = -1122241272387860545L;
    @TableId(value = "department_id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "department_name")
    private String name;

    @TableField(value = "department_location")
    private String location;

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
