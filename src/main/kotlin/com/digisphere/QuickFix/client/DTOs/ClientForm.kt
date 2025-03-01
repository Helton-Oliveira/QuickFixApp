package com.digisphere.QuickFix.client.DTOs

import com.digisphere.QuickFix.client.domain.Role

data class ClientForm (
    val name: String,
    val email: String,
    val cpf: String,
    val password: String,
    val role: Role
)
