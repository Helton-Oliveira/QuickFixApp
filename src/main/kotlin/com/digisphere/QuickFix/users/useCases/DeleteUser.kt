package com.digisphere.QuickFix.users.useCases

interface DeleteUser {
    fun execute(id: Long): String
}