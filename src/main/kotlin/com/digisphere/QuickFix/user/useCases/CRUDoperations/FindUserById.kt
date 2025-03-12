package com.digisphere.QuickFix.user.useCases.CRUDoperations

import com.digisphere.QuickFix.users.user.DTOs.UserView

interface FindUserById {
    fun execute(id: Long): UserView
}