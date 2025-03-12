package com.digisphere.QuickFix.user.useCases.CRUDoperations

interface DeleteUser {
    fun execute(id: Long): String
}