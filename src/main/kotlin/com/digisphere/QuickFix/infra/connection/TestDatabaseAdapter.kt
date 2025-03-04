package com.digisphere.QuickFix.infra.connection

import jakarta.persistence.EntityManager
import jakarta.persistence.Persistence

class TestDatabaseAdapter : Connection {
    private val entityManagerFactory = Persistence.createEntityManagerFactory("h2db")
    private val entityManager: EntityManager = entityManagerFactory.createEntityManager()

    override fun <T> executeTransaction(action: (EntityManager) -> T): T {
        entityManager.transaction.begin()
        val entity = action(entityManager)
        entityManager.transaction.commit()
        return entity
    }
}