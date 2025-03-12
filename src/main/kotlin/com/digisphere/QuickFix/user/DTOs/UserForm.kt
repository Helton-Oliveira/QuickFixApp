package com.digisphere.QuickFix.user.DTOs

import com.digisphere.QuickFix.users.user.typeUsers.Type

data class UserForm (
    val name: String,
    val email: String,
    val cpf: String,
    val password: String,
    val type: Type,
    val phone: String
)
