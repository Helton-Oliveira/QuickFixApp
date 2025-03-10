package com.digisphere.QuickFix.users.sharedResources.sharedUseCases

import com.digisphere.QuickFix.users.clientUser.DTOs.UserView
import com.digisphere.QuickFix.users.sharedResources.infra.entities.UserEntity
import com.digisphere.QuickFix.users.sharedResources.infra.entities.util.toViewModel
import com.digisphere.QuickFix.infra.repository.GenericRepository

class FindUserByIdImpl(private val repository: GenericRepository) : FindUserById {

    override fun execute(id: Long): UserView {
        val entity = repository.getById<UserEntity>(id)
        return entity.toViewModel()
    }
}