package com.digisphere.QuickFix.user.DTOs

import com.digisphere.QuickFix.users.user.typeUsers.Type

data class UserView (
    val id: Long,
    val name: String,
    val email: String,
    val phone: String,
    val cpf: String,
    val type: Type,
)
