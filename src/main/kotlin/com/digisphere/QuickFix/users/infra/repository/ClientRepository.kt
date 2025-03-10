package com.digisphere.QuickFix.users.infra.repository

import com.digisphere.QuickFix.users.infra.entities.UserEntity
import com.digisphere.QuickFix.infra.connection.Connection
import com.digisphere.QuickFix.infra.repository.GenericRepositoryImpl

class ClientRepository(manager: Connection)
    : GenericRepositoryImpl<UserEntity>(manager) {
        init {
            this.entityType = UserEntity::class.java
        }
    }