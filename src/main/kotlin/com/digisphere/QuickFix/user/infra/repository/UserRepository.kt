package com.digisphere.QuickFix.user.infra.repository

import com.digisphere.QuickFix.user.infra.entities.UserEntity

interface UserRepository {
    fun getAll(): List<UserEntity>
    fun getById(id: Long): UserEntity
    fun persist(entity: UserEntity): UserEntity
    fun deleteById(id: Long): Long
}