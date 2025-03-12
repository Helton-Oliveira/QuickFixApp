package com.digisphere.QuickFix.user.infra.entities

import com.digisphere.QuickFix.users.user.typeUsers.Type
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class UserEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(unique = true)
    val cpf: String,
    @Column(name = "full_name")
    val fullName: String,
    val phone: String,
    val email: String,
    @Column(name = "password_hash")
    val passwordHash: String,
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    val userType: Type,
)