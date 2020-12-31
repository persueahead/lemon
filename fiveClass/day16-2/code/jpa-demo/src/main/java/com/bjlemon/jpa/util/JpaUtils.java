package com.bjlemon.jpa.util;

import javax.persistence.*;

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
