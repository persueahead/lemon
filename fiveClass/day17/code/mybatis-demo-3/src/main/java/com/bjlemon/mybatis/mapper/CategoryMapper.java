package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Category;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName CategoryMapper.java
 * @Description TODO
 * @createTime 2019年12月28日 21:17:00
 */
public interface CategoryMapper {

    Category findParentByName(String name);
}
