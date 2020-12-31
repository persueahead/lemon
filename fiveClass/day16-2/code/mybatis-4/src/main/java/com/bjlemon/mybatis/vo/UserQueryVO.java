package com.bjlemon.mybatis.vo;

import com.bjlemon.mybatis.domain.User;
import lombok.Data;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserQueryVO.java
 * @Description TODO
 * @createTime 2020年03月05日 22:49:00
 */
@Data
public class UserQueryVO extends User {

    private Float beginSalary;
    private Float endSalary;


}
