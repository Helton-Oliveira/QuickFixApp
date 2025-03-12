package com.digisphere.QuickFix.user.DTOs

data class UpdateCustomerDataForm (
    val id: Long,
    val name: String? = null,
    val email: String? = null,
    val password: String? = null
)
