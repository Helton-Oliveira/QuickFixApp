package com.digisphere.QuickFix.user.infra.repository

import com.digisphere.QuickFix.user.infra.entities.UserEntity

interface UserRepository {
    fun getAll(): List<com.digisphere.QuickFix.user.infra.entities.UserEntity>
    fun getById(id: Long): com.digisphere.QuickFix.user.infra.entities.UserEntity
    fun persist(entity: com.digisphere.QuickFix.user.infra.entities.UserEntity): com.digisphere.QuickFix.user.infra.entities.UserEntity
    fun deleteById(id: Long): Long
}