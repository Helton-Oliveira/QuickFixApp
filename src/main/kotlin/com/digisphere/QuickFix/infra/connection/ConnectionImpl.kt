package com.digisphere.QuickFix.infra.connection

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence

object ConnectionImpl : Connection {

    override fun createTestDatabase(): EntityManager {
        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("h2db")
        return factory.createEntityManager()
    }
}