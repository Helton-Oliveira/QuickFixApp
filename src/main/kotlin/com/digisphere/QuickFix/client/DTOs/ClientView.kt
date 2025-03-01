package com.digisphere.QuickFix.client.DTOs

import com.digisphere.QuickFix.client.domain.Role

data class ClientView (
    val name: String,
    val email: String,
    val cpf: String,
    val role: Role,
)
