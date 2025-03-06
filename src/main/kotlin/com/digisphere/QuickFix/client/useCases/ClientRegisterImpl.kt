package com.digisphere.QuickFix.client.useCases

import com.digisphere.QuickFix.client.DTOs.ClientForm
import com.digisphere.QuickFix.client.DTOs.ClientView
import com.digisphere.QuickFix.infra.repository.GenericRepository
import com.digisphere.QuickFix.client.infra.entities.util.toEntity
import com.digisphere.QuickFix.client.infra.entities.util.toViewModel

class ClientRegisterImpl(private val repository: GenericRepository)
    : ClientRegister {

    override fun execute(data: ClientForm): ClientView {
        val entity = repository.persist(data.toEntity())
        return entity.toViewModel()
    }
}