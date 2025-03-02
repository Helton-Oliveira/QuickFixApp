package com.digisphere.QuickFix.infra.repository

import com.digisphere.QuickFix.infra.connection.Connection
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class GenericRepositoryImpl<TEntity : Any>(
    @PersistenceContext protected val connection: Connection,
    protected val entityType: Class<TEntity>
) : GenericRepository {

    @Transactional
    override fun getAll(): List<TEntity> {
        val query = connection.executeTransaction{em ->
            val query = em.createQuery("FROM ${entityType.simpleName}", entityType)
            query.resultList
        }
        return query
    }

    @Transactional
    override fun <ID> deleteById(id: ID) {
        val query = connection.executeTransaction{ em ->
            em.createQuery("FROM ${entityType.simpleName} WHERE id=:id ", entityType)
        }
        query.setParameter("id", id)
        val entity = query.singleResult
        connection.executeTransaction { em ->
            em.remove(if (em.contains(entity)) entity else em.merge(entity))
            entity
        }
    }

    @Transactional
    override fun <TEntity> persist(entity: TEntity): TEntity {
        return connection.executeTransaction { em ->
            em.merge(entity)
        }
    }

    @Transactional
    override fun <ID> getById(id: ID): TEntity {
        return connection.executeTransaction { em ->
            val query = em.createQuery("FROM ${entityType.simpleName} WHERE id=:id ", entityType)
            query.setParameter("id", id)
            query.singleResult
        }

    }
}