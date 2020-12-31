package com.bjlemon.mybatis.mapper;

import com.bjlemon.mybatis.domain.Animal;
import com.bjlemon.mybatis.domain.Cat;
import com.bjlemon.mybatis.domain.Dog;
import com.bjlemon.mybatis.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName AnimalMapperTest.java
 * @Description TODO
 * @createTime 2020年03月05日 21:52:00
 */
public class AnimalMapperTest {

    @Test
    public void saveCat() {
        SqlSession sqlSession = null;
        Cat cat = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            AnimalMapper mapper = sqlSession.getMapper(AnimalMapper.class);
            cat = new Cat();
            cat.setName("小猫");
            cat.setEyeColor("blue");

            mapper.saveCat(cat);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Test
    public void saveDog() {
        SqlSession sqlSession = null;
        Dog dog = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            AnimalMapper mapper = sqlSession.getMapper(AnimalMapper.class);
            dog = new Dog();
            dog.setName("小猫狗");
            dog.setFurColor("black");

            mapper.saveDog(dog);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Test
    public void findById() {
        SqlSession sqlSession = null;
        Dog dog = null;
        Cat cat = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            AnimalMapper mapper = sqlSession.getMapper(AnimalMapper.class);

            Animal animal = mapper.findById(2);
            if (animal instanceof Cat) {
                cat = (Cat) animal;
                System.out.println(cat);
            } else if (animal instanceof Dog) {
                dog = (Dog) animal;
                System.out.println(dog);
            }

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }
}