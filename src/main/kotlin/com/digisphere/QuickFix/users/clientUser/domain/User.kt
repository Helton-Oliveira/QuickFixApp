package com.digisphere.QuickFix.users.clientUser.domain

import com.digisphere.QuickFix.users.clientUser.DTOs.UpdateCustomerDataForm
import com.digisphere.QuickFix.users.sharedResources.typeUsers.Type

class User (
    val id: Long? = null,
    val cpf: String,
    name: String,
    email: String,
    phone: String,
    password: String,
    val type: Type,
) {

    var name: String = name
        private set
    var email: String = email
        private set
    var password: String = password
        private set
    var phone: String = phone
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
        return "Client(id=$id, cpf='$cpf', role=$type, name='$name', email='$email', password='$password')"
    }


}