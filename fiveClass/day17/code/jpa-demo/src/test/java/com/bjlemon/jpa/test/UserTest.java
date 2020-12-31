package com.bjlemon.jpa.test;

import com.bjlemon.jpa.domain.User;
import com.bjlemon.jpa.util.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName UserTest.java
 * @Description TODO
 * @createTime 2020年01月14日 21:25:00
 */
public class UserTest {

    @Test
    public void testAdd() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            user = new User();
            user.setName("zhangsan");
            user.setPassword("admin");
            user.setSalary(12.34F);
            user.setBirthday(new Date());

            entityManager.persist(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            JpaUtils.closeEntityManager(entityManager);
        }
    }

    @Test
    public void testDelete() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // 查询的是一个代理对象（User）,使用到了延迟加载技术
            // 问题:不要过早关闭EntityManager，如果关了那么代理对象不能初始化，导致出问题
            // 怎么解决问题：web项目配置一个过滤器（OpenEntityManagerInViewFilter）
            user = entityManager.getReference(User.class, 3);
//            Hibernate.initialize(user);

            // 真正查询User类型的对象
//            user = entityManager.find(User.class, 1);
            entityManager.remove(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            JpaUtils.closeEntityManager(entityManager);
        }
    }


    @Test
    public void testUpdate() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // 真正查询User类型的对象
            user = entityManager.find(User.class, 1);
            user.setName("C罗");
            user.setSalary(99.00F);

            entityManager.merge(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            JpaUtils.closeEntityManager(entityManager);
        }
    }

    @Test
    public void testFindAll() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();


            List userList = entityManager.createQuery("from User u").getResultList();
            userList.stream().forEach(System.out::println);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            JpaUtils.closeEntityManager(entityManager);
        }
    }

    @Test
    public void testFind() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            user = (User) entityManager.createQuery("from User u where u.name = ?1 and u.password = ?2")
                    .setParameter(1, "zhangsan")
                    .setParameter(2, "admin")
                    .getSingleResult();
            System.out.println(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            JpaUtils.closeEntityManager(entityManager);
        }
    }

    @Test
    public void testFind1() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        User user = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            user = (User) entityManager.createQuery("from User u where u.name = :uname and u.password = :pwd")
                    .setParameter("uname", "zhangsan")
                    .setParameter("pwd", "admin")
                    .getSingleResult();
            System.out.println(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            JpaUtils.closeEntityManager(entityManager);
        }
    }

    @Test
    public void testFind2() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        List<User> userList = Collections.EMPTY_LIST;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Integer pageNum = 2;
            Integer pageSize = 3;
            userList = entityManager.createQuery("from User u")
                    .setFirstResult((pageNum - 1) * pageSize)
                    .setMaxResults(3)
                    .getResultList();

            userList.stream().forEach(System.out::println);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            JpaUtils.closeEntityManager(entityManager);
        }
    }


}
