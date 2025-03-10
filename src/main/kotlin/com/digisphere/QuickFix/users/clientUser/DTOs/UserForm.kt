package com.digisphere.QuickFix.users.clientUser.DTOs

import com.digisphere.QuickFix.users.sharedResources.typeUsers.Type

data class UserForm (
    val name: String,
    val email: String,
    val cpf: String,
    val password: String,
    val type: Type,
    val phone: String
)
