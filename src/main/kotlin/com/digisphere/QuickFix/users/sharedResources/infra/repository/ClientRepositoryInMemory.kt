package com.digisphere.QuickFix.users.sharedResources.infra.repository

import com.digisphere.QuickFix.users.sharedResources.infra.entities.UserEntity
import com.digisphere.QuickFix.infra.repository.GenericRepository

class ClientRepositoryInMemory : GenericRepository{
    private val fakeData = mutableListOf<UserEntity>()

    override fun <Any> getAll(): List<Any> {
        TODO("Not yet implemented")
    }

    override fun <Any> getById(id: Long): Any {
        TODO("Not yet implemented")
    }

    override fun <Any> persist(entity: Any): Any {
        if(entity is UserEntity) {
            fakeData.add(entity)
            return fakeData.first { e -> e.cpf == entity.cpf } as Any
        }
        throw IllegalArgumentException("Invalid entity type")
    }

    override fun <Any> deleteById(id: Long): Any {
        TODO("Not yet implemented")
    }
}