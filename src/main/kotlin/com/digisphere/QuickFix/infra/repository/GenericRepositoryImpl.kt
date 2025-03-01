package com.digisphere.QuickFix.infra.repository

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class GenericRepositoryImpl<TEntity : Any, ID : Any>(
    @PersistenceContext protected val manager: EntityManager,
    protected val entityType: Class<TEntity>
) : GenericRepository<TEntity, ID>  {

    @Transactional
    override fun getAll(): List<TEntity> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList
    }

    @Transactional
    override fun deleteById(id: ID) {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id ", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult
        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
        manager.close()
    }

    @Transactional
    override fun persist(entity: TEntity): TEntity {
        return manager.merge(entity)
    }

    @Transactional
    override fun getById(id: ID): TEntity {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id ", entityType)
        query.setParameter("id", id)
        return query.singleResult
    }
}