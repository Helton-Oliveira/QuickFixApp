package com.digisphere.QuickFix.infra.connection

import jakarta.persistence.EntityManager

interface Connection {
    fun createTestDatabase(): EntityManager
}