package com.digisphere.QuickFix.client.useCases

interface DeleteClient {
    fun execute(id: Long): String
}