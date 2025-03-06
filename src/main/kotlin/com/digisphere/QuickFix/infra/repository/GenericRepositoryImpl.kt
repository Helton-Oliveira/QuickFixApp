package com.digisphere.QuickFix.infra.repository

import com.digisphere.QuickFix.infra.connection.Connection
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class GenericRepositoryImpl<TEntity : Any>(
    protected val connection: Connection,
) : GenericRepository {
    protected final lateinit var entityType: Class<TEntity>

    @Transactional
    override fun <TEntity> getAll(): List<TEntity> {
        val query = connection.executeTransaction{em ->
            val query = em.createQuery("FROM ${entityType.simpleName}", entityType)
            query.resultList
        }
        return query.map { entity -> entity as TEntity }
    }

    @Transactional
    override fun <TEntity> deleteById(id: Long): TEntity {
        val query = connection.executeTransaction{ em ->
            em.createQuery("FROM ${entityType.simpleName} WHERE id=:id ", entityType)
        }
        query.setParameter("id", id)
        val entity = query.singleResult
        return connection.executeTransaction { em ->
            em.remove(if (em.contains(entity)) entity else em.merge(entity))
            entity as TEntity
        }
    }

    @Transactional
    override fun <TEntity> persist(entity: TEntity): TEntity {
        return connection.executeTransaction { em ->
            em.merge(entity)
        }
    }

    @Transactional
    override fun <TEntity> getById(id: Long): TEntity {
        return connection.executeTransaction { em ->
            val query = em.createQuery("FROM ${entityType.simpleName} WHERE id=:id ", entityType).also {
                it.setParameter("id", id)
            }
            query.singleResult as TEntity
        }
    }
}