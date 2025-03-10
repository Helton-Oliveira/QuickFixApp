package com.digisphere.QuickFix.users.useCases

import com.digisphere.QuickFix.users.DTOs.UserForm
import com.digisphere.QuickFix.users.DTOs.UserView
import com.digisphere.QuickFix.infra.repository.GenericRepository
import com.digisphere.QuickFix.users.infra.entities.util.toEntity
import com.digisphere.QuickFix.users.infra.entities.util.toViewModel

class UserRegisterImpl(private val repository: GenericRepository)
    : UserRegister {

    override fun execute(data: UserForm): UserView {
        val entity = repository.persist(data.toEntity())
        return entity.toViewModel()
    }
}