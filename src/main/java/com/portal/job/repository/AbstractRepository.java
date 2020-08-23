package com.portal.job.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void persist(Object entity) {
        getEntityManager().persist(entity);
    }

    public void remove(Object entity) {
        getEntityManager().remove(entity);
    }
}
