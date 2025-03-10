package com.digisphere.QuickFix.users.sharedResources.infra.repository

import com.digisphere.QuickFix.users.sharedResources.infra.entities.UserEntity
import com.digisphere.QuickFix.infra.connection.Connection
import com.digisphere.QuickFix.infra.repository.GenericRepositoryImpl

class UserRepository(manager: Connection)
    : GenericRepositoryImpl<UserEntity>(manager) {
        init {
            this.entityType = UserEntity::class.java
        }
    }