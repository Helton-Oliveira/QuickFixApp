package com.digisphere.QuickFix.users.sharedResources.sharedUseCases

interface DeleteUser {
    fun execute(id: Long): String
}