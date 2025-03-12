package com.digisphere.QuickFix.user.useCases.CRUDoperations

import com.digisphere.QuickFix.users.user.DTOs.UserView
import com.digisphere.QuickFix.users.user.infra.entities.util.toViewModel

class FindUserByIdImpl(private val repository: com.digisphere.QuickFix.user.infra.repository.UserRepository) :
    FindUserById {

    override fun execute(id: Long): UserView {
        val entity = repository.getById(id)
        return entity.toViewModel()
    }
}