package com.digisphere.QuickFix.users.useCases

import com.digisphere.QuickFix.users.DTOs.UserView
import com.digisphere.QuickFix.users.DTOs.UpdateCustomerDataForm

interface UpdateUser {
    fun execute(newData: UpdateCustomerDataForm): UserView
}