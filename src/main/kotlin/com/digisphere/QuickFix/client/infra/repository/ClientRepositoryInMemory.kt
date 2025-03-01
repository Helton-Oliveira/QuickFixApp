package com.digisphere.QuickFix.client.infra.repository

import com.digisphere.QuickFix.client.infra.entities.ClientEntity
import com.digisphere.QuickFix.infra.repository.GenericRepository

class ClientRepositoryInMemory : GenericRepository<ClientEntity, String> {
    private val fakeData = mutableListOf<ClientEntity>()

    override fun getAll(): List<ClientEntity> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }

    override fun persist(entity: ClientEntity): ClientEntity {
        fakeData.add(entity)
        return fakeData.first { e -> e.cpf == entity.cpf }
    }

    override fun getById(id: String): ClientEntity {
        TODO("Not yet implemented")
    }
}