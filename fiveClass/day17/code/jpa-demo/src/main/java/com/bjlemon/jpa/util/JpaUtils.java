package com.bjlemon.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author jeffzhou
 * @version 1.0.0
 * @ClassName JpaUtils.java
 * @Description TODO
 * @createTime 2020年01月14日 21:26:00
 */
public class JpaUtils {

    private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("jpa-demo");
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager entityManager) {
        if (entityManager != null) {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
