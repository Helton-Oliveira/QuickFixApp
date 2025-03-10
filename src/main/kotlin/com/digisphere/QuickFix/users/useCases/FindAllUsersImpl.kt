package com.digisphere.QuickFix.users.useCases

import com.digisphere.QuickFix.users.DTOs.UserView
import com.digisphere.QuickFix.users.infra.entities.UserEntity
import com.digisphere.QuickFix.users.infra.entities.util.toViewModel
import com.digisphere.QuickFix.infra.repository.GenericRepository

class FindAllUsersImpl(private val repository: GenericRepository): FindAllUsers {

    override fun execute(): List<UserView> {
        val entities = repository.getAll<UserEntity>()
        return entities.map { entity -> entity.toViewModel() }
    }
}