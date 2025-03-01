package com.digisphere.QuickFix.client.infra.entities

import com.digisphere.QuickFix.client.domain.Role
import jakarta.persistence.*

@Entity
data class ClientEntity (
    @Id
    @Column(unique = true)
    val cpf: String,
    val name: String,
    val email: String,
    val password: String,
    @Enumerated(EnumType.STRING)
    val role: Role,
)