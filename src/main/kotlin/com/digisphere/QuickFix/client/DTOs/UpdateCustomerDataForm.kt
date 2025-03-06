package com.digisphere.QuickFix.client.DTOs

data class UpdateCustomerDataForm (
    val id: Long,
    val name: String? = null,
    val email: String? = null,
    val password: String? = null
)
