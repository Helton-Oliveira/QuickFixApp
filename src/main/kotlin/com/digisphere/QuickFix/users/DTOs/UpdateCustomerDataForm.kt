package com.digisphere.QuickFix.users.DTOs

data class UpdateCustomerDataForm (
    val id: Long,
    val name: String? = null,
    val email: String? = null,
    val password: String? = null
)
