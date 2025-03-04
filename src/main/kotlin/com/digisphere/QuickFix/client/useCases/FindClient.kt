package com.digisphere.QuickFix.client.useCases

import com.digisphere.QuickFix.client.DTOs.ClientView

interface FindClient {
    fun execute(id: Long): ClientView
}