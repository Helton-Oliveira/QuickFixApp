package com.digisphere.QuickFix.users.useCases

import com.digisphere.QuickFix.users.DTOs.UserView

interface FindAllUsers {
    fun execute(): List<UserView>
}