package com.digisphere.QuickFix.user.domain

import com.digisphere.QuickFix.users.user.DTOs.UpdateCustomerDataForm
import com.digisphere.QuickFix.users.user.typeUsers.Type
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class User (
    val id: Long? = null,
    val cpf: String,
    name: String,
    email: String,
    phone: String,
    password: String,
    val userType: Type,
) {

    var fullName: String = name
        private set
    var email: String = email
        private set
    var passwordHash: String = password
        private set
    var phone: String = phone
        private set

    fun update(newData: UpdateCustomerDataForm) {

        if(newData.name?.isNotBlank() == true) {
            this.fullName = newData.name
        }

        if(newData.email?.isNotBlank() == true) {
            this.email = newData.email
        }

        if(newData.password?.isNotBlank() == true) {
            this.passwordHash = newData.password
        }
    }

    fun passwordEncoder() {

        this.passwordHash = BCryptPasswordEncoder().encode(this.passwordHash)
    }
}