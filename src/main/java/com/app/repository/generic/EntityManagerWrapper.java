package com.app.repository.generic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EntityManagerWrapper implements AutoCloseable {
    private final EntityManager entityManager;

    public EntityManagerWrapper(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void close() throws Exception {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}