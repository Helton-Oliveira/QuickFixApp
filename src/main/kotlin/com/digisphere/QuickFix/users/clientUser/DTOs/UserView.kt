package com.digisphere.QuickFix.users.clientUser.DTOs

import com.digisphere.QuickFix.users.sharedResources.typeUsers.Type

data class UserView (
    val id: Long,
    val name: String,
    val email: String,
    val phone: String,
    val cpf: String,
    val type: Type,
)
