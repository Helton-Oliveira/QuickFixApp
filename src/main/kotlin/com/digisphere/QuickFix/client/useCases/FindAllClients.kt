package com.digisphere.QuickFix.client.useCases

import com.digisphere.QuickFix.client.DTOs.ClientView

interface FindAllClients {
    fun execute(): List<ClientView>
}