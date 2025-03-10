package com.digisphere.QuickFix.users.useCases

import com.digisphere.QuickFix.users.DTOs.UserForm
import com.digisphere.QuickFix.users.DTOs.UserView

interface UserRegister {
    fun execute(data: UserForm): UserView
}