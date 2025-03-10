package com.digisphere.QuickFix.users.useCases

import com.digisphere.QuickFix.users.DTOs.UserView
import com.digisphere.QuickFix.users.infra.entities.UserEntity
import com.digisphere.QuickFix.users.infra.entities.util.toViewModel
import com.digisphere.QuickFix.infra.repository.GenericRepository

class FindUserByIdImpl(private val repository: GenericRepository) : FindUserById {

    override fun execute(id: Long): UserView {
        val entity = repository.getById<UserEntity>(id)
        return entity.toViewModel()
    }
}