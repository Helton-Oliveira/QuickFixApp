package com.digisphere.QuickFix.infra.connection

import jakarta.persistence.EntityManager
import jakarta.persistence.TypedQuery

interface Connection<TEntity> {
    fun executeTransaction(action: (EntityManager) -> TEntity): TEntity
    fun query(statement: String, entityType: Class<TEntity>): TypedQuery<TEntity>
}