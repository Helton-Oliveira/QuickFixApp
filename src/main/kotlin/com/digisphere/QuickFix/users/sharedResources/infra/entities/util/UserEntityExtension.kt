package com.digisphere.QuickFix.users.sharedResources.infra.entities.util

import com.digisphere.QuickFix.users.clientUser.DTOs.UserForm
import com.digisphere.QuickFix.users.clientUser.DTOs.UserView
import com.digisphere.QuickFix.users.clientUser.domain.User
import com.digisphere.QuickFix.users.sharedResources.infra.entities.UserEntity

fun UserEntity.toViewModel(): UserView {
    return UserView(
        name = this.fullName,
        email = this.email,
        phone = this.phone,
        cpf = this.cpf,
        type = this.userType,
        id = this.id ?: 0L
    )
}

fun UserEntity.toDomainModel(): User {
    return User(
        id = this.id,
        name = this.fullName,
        email = this.email,
        cpf = this.cpf,
        password = this.passwordHash,
        type = this.userType,
        phone = this.phone
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        cpf = this.cpf,
        fullName = this.name,
        email = this.email,
        passwordHash = this.password,
        userType = this.type,
        phone = this.phone
    )
}

fun UserForm.toEntity(): UserEntity {
    return UserEntity(
        cpf = this.cpf,
        fullName = this.name,
        email = this.email,
        passwordHash = this.password,
        phone = this.phone,
        userType = this.type
    )
}