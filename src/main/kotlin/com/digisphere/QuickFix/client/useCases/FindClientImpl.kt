package com.digisphere.QuickFix.client.useCases

import com.digisphere.QuickFix.client.DTOs.ClientView
import com.digisphere.QuickFix.client.infra.entities.ClientEntity
import com.digisphere.QuickFix.client.infra.entities.util.toModel
import com.digisphere.QuickFix.infra.repository.GenericRepository

class FindClientImpl(private val repository: GenericRepository) : FindClient {

    override fun execute(id: Long): ClientView {
        val entity = repository.getById<ClientEntity>(id)
        return entity.toModel()
    }
}