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
 * @createTime 2019年12月28日 21:35:00
 */
public class AnimalMapperTest {

    @Test
    public void findById() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            AnimalMapper animalMapper = sqlSession.getMapper(AnimalMapper.class);

            Animal animal = animalMapper.findById(1);
            if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                System.out.println(cat);
            } else if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                System.out.println(dog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }

    @Test
    public void saveCat() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            AnimalMapper animalMapper = sqlSession.getMapper(AnimalMapper.class);

            Cat cat = new Cat();
            cat.setName("小猫");
            cat.setEyeColor("blue");
            animalMapper.saveCat(cat);

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

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            AnimalMapper animalMapper = sqlSession.getMapper(AnimalMapper.class);

            Dog dog = new Dog();
            dog.setName("小狗");
            dog.setFurColor("black");
            animalMapper.saveDog(dog);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession();
        }
    }
}