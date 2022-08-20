package com.example.phuong.vno.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersistenceUtil {

    // <persistence-unit name="vno-hibernate" transaction-type="JTA">,
    // cho nay se lookup roi tim voi name = vno-hibernate

    @PersistenceContext(unitName = "vno-hibernate")
    private EntityManager entityManager;

    public PersistenceUtil() {
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
