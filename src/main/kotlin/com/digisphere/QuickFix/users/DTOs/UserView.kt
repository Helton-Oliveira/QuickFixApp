package com.digisphere.QuickFix.users.DTOs

import com.digisphere.QuickFix.users.domain.Role

data class UserView (
    val id: Long,
    val name: String,
    val email: String,
    val cpf: String,
    val role: Role,
)
