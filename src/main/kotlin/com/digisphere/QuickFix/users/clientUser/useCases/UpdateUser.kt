package com.digisphere.QuickFix.users.clientUser.useCases

import com.digisphere.QuickFix.users.clientUser.DTOs.UserView
import com.digisphere.QuickFix.users.clientUser.DTOs.UpdateCustomerDataForm

interface UpdateUser {
    fun execute(newData: UpdateCustomerDataForm): UserView
}