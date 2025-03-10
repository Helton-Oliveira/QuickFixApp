package com.digisphere.QuickFix.users.infra.entities

import com.digisphere.QuickFix.users.domain.Role
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity (
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