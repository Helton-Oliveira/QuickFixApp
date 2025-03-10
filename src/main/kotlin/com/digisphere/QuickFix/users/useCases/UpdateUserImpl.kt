package com.digisphere.QuickFix.users.useCases

import com.digisphere.QuickFix.users.DTOs.UserView
import com.digisphere.QuickFix.users.DTOs.UpdateCustomerDataForm
import com.digisphere.QuickFix.users.infra.entities.UserEntity
import com.digisphere.QuickFix.users.infra.entities.util.toDomainModel
import com.digisphere.QuickFix.users.infra.entities.util.toEntity
import com.digisphere.QuickFix.users.infra.entities.util.toViewModel
import com.digisphere.QuickFix.infra.repository.GenericRepository

class UpdateUserImpl(private val repository: GenericRepository) : UpdateUser {

    override fun execute(newData: UpdateCustomerDataForm): UserView {
        val userEntity = repository.getById<UserEntity>(newData.id)
        val clientDomain = userEntity.toDomainModel()
        clientDomain.update(newData)
        return repository.persist(clientDomain.toEntity()).toViewModel()
    }
}