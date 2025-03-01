package com.digisphere.QuickFix.infra.repository

import com.digisphere.QuickFix.infra.connection.Connection
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class GenericRepositoryImpl<TEntity : Any, ID : Any>(
    @PersistenceContext protected val connection: Connection<TEntity>,
    protected val entityType: Class<TEntity>
) : GenericRepository<TEntity, ID>  {

    @Transactional
    override fun getAll(): List<TEntity> {
        val query = connection.query("FROM ${entityType.simpleName}", entityType)
        return query.resultList
    }

    @Transactional
    override fun deleteById(id: ID) {
        val query = connection.query("FROM ${entityType.simpleName} WHERE id=:id ", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult
        connection.executeTransaction { em ->
            em.remove(if (em.contains(entity)) entity else em.merge(entity))
            entity
        }
    }

    @Transactional
    override fun persist(entity: TEntity): TEntity {
        return connection.executeTransaction { em ->
            em.merge(entity)
        }
    }

    @Transactional
    override fun getById(id: ID): TEntity {
        val query = connection.query("FROM ${entityType.simpleName} WHERE id=:id ", entityType)
        query.setParameter("id", id)
        return query.singleResult
    }
}