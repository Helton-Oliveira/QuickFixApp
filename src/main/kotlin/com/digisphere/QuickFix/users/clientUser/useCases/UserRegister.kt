package com.digisphere.QuickFix.users.clientUser.useCases

import com.digisphere.QuickFix.users.clientUser.DTOs.UserForm
import com.digisphere.QuickFix.users.clientUser.DTOs.UserView

interface UserRegister {
    fun execute(data: UserForm): UserView
}