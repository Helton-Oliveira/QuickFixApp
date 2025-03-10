package com.digisphere.QuickFix.users.sharedResources.sharedUseCases

import com.digisphere.QuickFix.users.clientUser.DTOs.UserView

interface FindUserById {
    fun execute(id: Long): UserView
}