package com.digisphere.QuickFix.client.domain

import com.digisphere.QuickFix.client.DTOs.UpdateCustomerDataForm

data class Client (
     var cpf: String,
     var name: String,
     var email: String,
     var password: String,
     var role: Role,
) {
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
}