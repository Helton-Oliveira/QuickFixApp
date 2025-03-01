package com.digisphere.QuickFix.util

import com.digisphere.QuickFix.client.DTOs.ClientForm
import com.digisphere.QuickFix.client.DTOs.ClientView
import com.digisphere.QuickFix.client.infra.entities.ClientEntity

fun ClientEntity.toModel(): ClientView {
    return ClientView(
        name = this.name,
        email = this.email,
        cpf = this.cpf,
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