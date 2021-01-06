package com.bjlemon.domain;

import com.baomidou.mybatisplus.annotation.TableField;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * ClassName User
 * Description TODO
 * Author Administrator
 * Date 2018/12/1314:16
 * Version 1.0
 */
@Data
//@TableName(value = "sys_user")
public class User extends Model {

    //@TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String email;
    @TableField(value = "card")
    private String idCard;

    private  String sex;
    private  Integer age;
}
