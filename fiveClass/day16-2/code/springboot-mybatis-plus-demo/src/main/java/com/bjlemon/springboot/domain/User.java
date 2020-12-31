package com.bjlemon.springboot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sm_user")
public class User implements Serializable {

    private static final long serialVersionUID = -6048472400496098620L;
    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_name")
    private String name;

    @TableField(value = "user_password")
    private String password;

    @TableField(value = "user_salary")
    private Float salary;

    @TableField(value = "user_birthday")
    private Date birthday;

    @TableField(value = "department_id")
    private Department department;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}
