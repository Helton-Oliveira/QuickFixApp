package com.digisphere.QuickFix.client.domain

data class Client (
    val cpf: String,
    val name: String,
    val email: String,
    val password: String,
    val role: Role,
)