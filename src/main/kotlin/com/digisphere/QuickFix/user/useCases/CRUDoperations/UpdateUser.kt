package com.digisphere.QuickFix.user.useCases.CRUDoperations

import com.digisphere.QuickFix.users.user.DTOs.UserView
import com.digisphere.QuickFix.users.user.DTOs.UpdateCustomerDataForm

interface UpdateUser {
    fun execute(newData: UpdateCustomerDataForm): UserView
}