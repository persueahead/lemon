package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Category;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName CategoryMapper.java
 * @Description TODO
 * @createTime 2020年03月05日 21:29:00
 */
public interface CategoryMapper {

    Category findParentByName(String name);

    List<Category> findChildrenByName(String name);

}


