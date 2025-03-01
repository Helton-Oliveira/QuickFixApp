package com.digisphere.QuickFix.infra.repository

interface GenericRepository<TEntity, ID> {
    fun getAll(): List<TEntity>
    fun getById(id: ID): TEntity
    fun persist(entity: TEntity): TEntity
    fun deleteById(id: ID)
}