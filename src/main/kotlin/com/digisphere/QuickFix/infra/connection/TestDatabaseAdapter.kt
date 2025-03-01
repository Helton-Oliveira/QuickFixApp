package com.digisphere.QuickFix.infra.connection

import jakarta.persistence.EntityManager
import jakarta.persistence.Persistence
import jakarta.persistence.TypedQuery

class TestDatabaseAdapter<TEntity> : Connection<TEntity> {
    private val entityManagerFactory = Persistence.createEntityManagerFactory("h2db")
    private val entityManager: EntityManager = entityManagerFactory.createEntityManager()

    override fun query(statement: String, entityType: Class<TEntity>): TypedQuery<TEntity> {
        return entityManager.createQuery(statement, entityType)
    }

    override fun executeTransaction(action: (EntityManager) -> TEntity): TEntity {
        entityManager.transaction.begin()
        val entity = action(entityManager)
        entityManager.transaction.commit()
        return entity
    }
}