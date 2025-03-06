package com.digisphere.QuickFix.client.useCases

import com.digisphere.QuickFix.client.DTOs.ClientView
import com.digisphere.QuickFix.client.infra.entities.ClientEntity
import com.digisphere.QuickFix.client.infra.entities.util.toViewModel
import com.digisphere.QuickFix.infra.repository.GenericRepository

class FindAllClientsImpl(private val repository: GenericRepository): FindAllClients {

    override fun execute(): List<ClientView> {
        val entities = repository.getAll<ClientEntity>()
        return entities.map { entity -> entity.toViewModel() }
    }
}