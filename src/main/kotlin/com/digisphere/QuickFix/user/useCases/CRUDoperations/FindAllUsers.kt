package com.digisphere.QuickFix.user.useCases.CRUDoperations

import com.digisphere.QuickFix.users.user.DTOs.UserView

interface FindAllUsers {
    fun execute(): List<UserView>
}