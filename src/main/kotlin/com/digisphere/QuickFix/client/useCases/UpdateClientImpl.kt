package com.digisphere.QuickFix.client.useCases

import com.digisphere.QuickFix.client.DTOs.ClientView
import com.digisphere.QuickFix.client.DTOs.UpdateCustomerDataForm
import com.digisphere.QuickFix.client.infra.entities.ClientEntity
import com.digisphere.QuickFix.client.infra.entities.util.toDomainModel
import com.digisphere.QuickFix.client.infra.entities.util.toEntity
import com.digisphere.QuickFix.client.infra.entities.util.toViewModel
import com.digisphere.QuickFix.infra.repository.GenericRepository

class UpdateClientImpl(private val repository: GenericRepository) : UpdateClient {

    override fun execute(newData: UpdateCustomerDataForm): ClientView {
        var clientEntity = repository.getById<ClientEntity>(newData.id)
        val clientDomain = clientEntity.toDomainModel()
        clientDomain.update(newData)
        clientEntity = clientDomain.toEntity()
        repository.persist(clientEntity)
        return clientEntity.toViewModel()
    }
}