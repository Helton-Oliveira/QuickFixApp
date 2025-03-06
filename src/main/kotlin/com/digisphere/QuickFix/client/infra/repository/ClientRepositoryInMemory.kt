package com.digisphere.QuickFix.client.infra.repository

import com.digisphere.QuickFix.client.infra.entities.ClientEntity
import com.digisphere.QuickFix.infra.repository.GenericRepository

class ClientRepositoryInMemory : GenericRepository{
    private val fakeData = mutableListOf<ClientEntity>()

    override fun <Any> getAll(): List<Any> {
        TODO("Not yet implemented")
    }

    override fun <Any> getById(id: Long): Any {
        TODO("Not yet implemented")
    }

    override fun <Any> persist(entity: Any): Any {
        if(entity is ClientEntity) {
            fakeData.add(entity)
            return fakeData.first { e -> e.cpf == entity.cpf } as Any
        }
        throw IllegalArgumentException("Invalid entity type")
    }

    override fun <Any> deleteById(id: Long): Any {
        TODO("Not yet implemented")
    }
}