package com.digisphere.QuickFix.users.infra.entities.util

import com.digisphere.QuickFix.users.DTOs.UserForm
import com.digisphere.QuickFix.users.DTOs.UserView
import com.digisphere.QuickFix.users.domain.User
import com.digisphere.QuickFix.users.infra.entities.UserEntity

fun UserEntity.toViewModel(): UserView {
    return UserView(
        name = this.name,
        email = this.email,
        cpf = this.cpf,
        role = this.role,
        id = this.id ?: 0L
    )
}

fun UserEntity.toDomainModel(): User {
    return User(
        id = this.id,
        name = this.name,
        email = this.email,
        cpf = this.cpf,
        password = this.password,
        role = this.role
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        cpf = this.cpf,
        name = this.name,
        email = this.email,
        password = this.password,
        role = this.role
    )
}

fun UserForm.toEntity(): UserEntity {
    return UserEntity(
        cpf = this.cpf,
        name = this.name,
        email = this.email,
        password = this.password,
        role = this.role
    )
}