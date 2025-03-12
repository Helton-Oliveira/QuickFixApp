package com.digisphere.QuickFix.user.useCases.CRUDoperations

import com.digisphere.QuickFix.user.DTOs.UpdateCustomerDataForm
import com.digisphere.QuickFix.user.DTOs.UserView
import com.digisphere.QuickFix.user.infra.entities.util.toDomainModel
import com.digisphere.QuickFix.user.infra.entities.util.toEntity
import com.digisphere.QuickFix.user.infra.entities.util.toViewModel

class UpdateUserImpl(private val repository: com.digisphere.QuickFix.user.infra.repository.UserRepository) :
    UpdateUser {

    override fun execute(newData: UpdateCustomerDataForm): UserView {
        val userView = repository.getById(newData.id)
        val clientDomain = userView.toDomainModel()
        clientDomain.update(newData)
        return repository.persist(clientDomain.toEntity()).toViewModel()
    }
}