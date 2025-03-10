package com.digisphere.QuickFix.users.useCases

import com.digisphere.QuickFix.users.DTOs.UserView

interface FindUserById {
    fun execute(id: Long): UserView
}