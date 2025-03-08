package com.digisphere.QuickFix.client.infra.entities.util

import com.digisphere.QuickFix.client.DTOs.ClientForm
import com.digisphere.QuickFix.client.DTOs.ClientView
import com.digisphere.QuickFix.client.domain.Client
import com.digisphere.QuickFix.client.infra.entities.ClientEntity

fun ClientEntity.toViewModel(): ClientView {
    return ClientView(
        name = this.name,
        email = this.email,
        cpf = this.cpf,
        role = this.role,
        id = this.id ?: 0L
    )
}

fun ClientEntity.toDomainModel(): Client {
    return Client(
        id = this.id,
        name = this.name,
        email = this.email,
        cpf = this.cpf,
        password = this.password,
        role = this.role
    )
}

fun Client.toEntity(): ClientEntity {
    return ClientEntity(
        id = this.id,
        cpf = this.cpf,
        name = this.name,
        email = this.email,
        password = this.password,
        role = this.role
    )
}

fun ClientForm.toEntity(): ClientEntity {
    return ClientEntity(
        cpf = this.cpf,
        name = this.name,
        email = this.email,
        password = this.password,
        role = this.role
    )
}