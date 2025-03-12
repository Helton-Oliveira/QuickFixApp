package com.digisphere.QuickFix.user.useCases.CRUDoperations

import com.digisphere.QuickFix.user.DTOs.UserForm
import com.digisphere.QuickFix.user.DTOs.UserView
import com.digisphere.QuickFix.user.infra.entities.util.toDomainModel
import com.digisphere.QuickFix.user.infra.entities.util.toEntity
import com.digisphere.QuickFix.user.infra.entities.util.toViewModel

class UserRegisterImpl(private val repository: com.digisphere.QuickFix.user.infra.repository.UserRepository)
    : UserRegister {

    override fun execute(data: UserForm): UserView {
        val domain = data.toDomainModel()
        domain.passwordEncoder()
        val entity = repository.persist(domain.toEntity())
        return entity.toViewModel()
    }
}