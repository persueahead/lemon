package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Animal;
import com.bjlemon.mybatis.domain.Cat;
import com.bjlemon.mybatis.domain.Dog;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName CategoryMapper.java
 * @Description TODO
 * @createTime 2020年03月05日 21:29:00
 */
public interface AnimalMapper {

    void saveCat(Cat cat);

    void saveDog(Dog dog);

    Animal findById(Integer id);
}


