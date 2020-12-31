package com.bjlemon.springboot.service.impl;

import com.bjlemon.springboot.domain.Person;
import com.bjlemon.springboot.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName PersonServiceImpl.java
 * @Description TODO
 * @createTime 2020年01月09日 20:53:00
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public List<Person> findAllPersonList() {
        List<Person> personList = new ArrayList<>();

        Person person1 = Person.builder().id(1).name("zhangsan").password("admin").salary(12.34F).birthday(new Date()).build();
        Person person2 = Person.builder().id(1).name("lisi").password("admin").salary(45.34F).birthday(new Date()).build();
        Person person3 = Person.builder().id(1).name("wangwu").password("admin").salary(33.34F).birthday(new Date()).build();
        Person person4 = Person.builder().id(1).name("C罗").password("admin").salary(88.34F).birthday(new Date()).build();
        Person person5 = Person.builder().id(1).name("梅西").password("admin").salary(77.34F).birthday(new Date()).build();

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        return personList;
    }
}
