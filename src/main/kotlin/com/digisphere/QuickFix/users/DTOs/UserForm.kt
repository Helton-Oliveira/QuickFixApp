package com.digisphere.QuickFix.users.DTOs

import com.digisphere.QuickFix.users.domain.Role

data class UserForm (
    val name: String,
    val email: String,
    val cpf: String,
    val password: String,
    val role: Role
)
