package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.IdCard;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName PersonMapper.java
 * @Description TODO
 * @createTime 2020年03月03日 21:45:00
 */
public interface PersonMapper {

    /**
     * @description
     * @author admin
     * @updateTime 2020/3/5 20:35
     */
    IdCard findIdCardByName(String name);

}
