package com.digisphere.QuickFix.client.useCases

import com.digisphere.QuickFix.client.DTOs.ClientForm
import com.digisphere.QuickFix.client.DTOs.ClientView
import com.digisphere.QuickFix.client.infra.entities.ClientEntity
import com.digisphere.QuickFix.infra.repository.GenericRepository
import com.digisphere.QuickFix.util.toEntity
import com.digisphere.QuickFix.util.toModel

class ClientRegisterImpl(private val repository: GenericRepository<ClientEntity, String>)
    : ClientRegister {

    override fun execute(data: ClientForm): ClientView {
        val entity = repository.persist(data.toEntity())
        return entity.toModel()
    }
}