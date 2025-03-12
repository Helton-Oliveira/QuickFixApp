package com.digisphere.QuickFix.user.useCases.CRUDoperations

import com.digisphere.QuickFix.users.user.DTOs.UserForm
import com.digisphere.QuickFix.users.user.DTOs.UserView

interface UserRegister {
    fun execute(data: UserForm): UserView
}