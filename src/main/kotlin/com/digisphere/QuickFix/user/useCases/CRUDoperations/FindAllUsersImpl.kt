package com.digisphere.QuickFix.user.useCases.CRUDoperations

import com.digisphere.QuickFix.users.user.DTOs.UserView
import com.digisphere.QuickFix.users.user.infra.entities.util.toViewModel

class FindAllUsersImpl(private val repository: com.digisphere.QuickFix.user.infra.repository.UserRepository):
    FindAllUsers {

    override fun execute(): List<UserView> {
        val entities = repository.getAll()
        return entities.map { entity -> entity.toViewModel() }
    }
}