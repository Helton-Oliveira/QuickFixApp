package com.digisphere.QuickFix.client.useCases

import com.digisphere.QuickFix.client.DTOs.ClientForm
import com.digisphere.QuickFix.client.DTOs.ClientView

interface ClientRegister {
    fun execute(data: ClientForm): ClientView
}