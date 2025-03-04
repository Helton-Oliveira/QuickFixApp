package com.digisphere.QuickFix.client.infra.entities

import com.digisphere.QuickFix.client.domain.Role
import jakarta.persistence.*

@Entity
@Table(name = "clients")
data class ClientEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(unique = true)
    val cpf: String,
    val name: String,
    val email: String,
    val password: String,
    @Enumerated(EnumType.STRING)
    val role: Role,
)