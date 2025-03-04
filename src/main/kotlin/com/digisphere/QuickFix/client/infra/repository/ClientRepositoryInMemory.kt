package com.digisphere.QuickFix.client.infra.repository

import com.digisphere.QuickFix.client.infra.entities.ClientEntity
import com.digisphere.QuickFix.infra.repository.GenericRepository

class ClientRepositoryInMemory : GenericRepository{
    private val fakeData = mutableListOf<ClientEntity>()

    override fun getAll(): List<Any> {
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

    override fun <ID> deleteById(id: ID) {
        TODO("Not yet implemented")
    }


    /*override fun <CLientEntity> persist(entity: ClientEntity): ClientEntity {

    }*/


}