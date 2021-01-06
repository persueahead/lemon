package com.bjlemon.mp.beans;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author bjlemon
 * @since 2018-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_employee")
public class Employee extends Model<Employee> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String empName;

    private String empJob;

    private BigDecimal empSalary;


    // 乐观锁需要的版本标识
    @Version
    private Integer version;


    @TableLogic
    private  Integer deleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
