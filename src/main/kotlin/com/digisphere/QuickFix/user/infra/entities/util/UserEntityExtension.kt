package com.digisphere.QuickFix.user.infra.entities.util

import com.digisphere.QuickFix.users.user.DTOs.UserForm
import com.digisphere.QuickFix.users.user.DTOs.UserView
import com.digisphere.QuickFix.users.user.domain.User
import com.digisphere.QuickFix.user.infra.entities.UserEntity

fun com.digisphere.QuickFix.user.infra.entities.UserEntity.toViewModel(): UserView {
    return UserView(
        name = this.fullName,
        email = this.email,
        phone = this.phone,
        cpf = this.cpf,
        type = this.userType,
        id = this.id ?: 0L
    )
}

fun com.digisphere.QuickFix.user.infra.entities.UserEntity.toDomainModel(): User {
    return User(
        id = this.id,
        name = this.fullName,
        email = this.email,
        cpf = this.cpf,
        password = this.passwordHash,
        userType = this.userType,
        phone = this.phone
    )
}

fun User.toEntity(): com.digisphere.QuickFix.user.infra.entities.UserEntity {
    return com.digisphere.QuickFix.user.infra.entities.UserEntity(
        id = this.id,
        cpf = this.cpf,
        fullName = this.fullName,
        email = this.email,
        passwordHash = this.passwordHash,
        userType = this.userType,
        phone = this.phone
    )
}

fun UserForm.toDomainModel(): User {
    return User(
        cpf = this.cpf,
        name = this.name,
        email = this.email,
        password = this.password,
        phone = this.phone,
        userType = this.type
    )
}