package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Animal;
import com.bjlemon.mybatis.domain.Cat;
import com.bjlemon.mybatis.domain.Dog;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName AnimalMapper.java
 * @Description TODO
 * @createTime 2019年12月28日 21:29:00
 */
public interface AnimalMapper {

    Animal findById(Integer id);

    void saveCat(Cat cat);

    void saveDog(Dog dog);

}
