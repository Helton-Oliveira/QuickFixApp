package com.digisphere.QuickFix.users.sharedResources.sharedUseCases

import com.digisphere.QuickFix.users.clientUser.DTOs.UserView

interface FindAllUsers {
    fun execute(): List<UserView>
}