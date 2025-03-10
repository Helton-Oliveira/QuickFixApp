package com.digisphere.QuickFix.users.domain

import com.digisphere.QuickFix.users.DTOs.UpdateCustomerDataForm

class User (
    val id: Long? = null,
    val cpf: String,
    name: String,
    email: String,
    password: String,
    val role: Role,
) {

    var name: String = name
        private set
    var email: String = email
        private set
    var password: String = password
        private set

    fun update(newData: UpdateCustomerDataForm) {

        if(newData.name?.isNotBlank() == true) {
            this.name = newData.name
        }

        if(newData.email?.isNotBlank() == true) {
            this.email = newData.email
        }

        if(newData.password?.isNotBlank() == true) {
            this.password = newData.password
        }
    }

    override fun toString(): String {
        return "Client(id=$id, cpf='$cpf', role=$role, name='$name', email='$email', password='$password')"
    }


}