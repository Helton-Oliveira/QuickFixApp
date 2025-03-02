package com.digisphere.QuickFix.infra.connection

import jakarta.persistence.EntityManager

interface Connection {
    fun <T> executeTransaction(action: (EntityManager) -> T ): T
}