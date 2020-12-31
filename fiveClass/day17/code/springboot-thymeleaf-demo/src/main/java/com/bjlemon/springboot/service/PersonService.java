package com.bjlemon.springboot.service;

import com.bjlemon.springboot.domain.Person;

import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName PersonService.java
 * @Description TODO
 * @createTime 2020年01月09日 20:52:00
 */
public interface PersonService {

    List<Person> findAllPersonList();
}
