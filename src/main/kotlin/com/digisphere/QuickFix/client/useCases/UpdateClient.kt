package com.digisphere.QuickFix.client.useCases

import com.digisphere.QuickFix.client.DTOs.ClientView
import com.digisphere.QuickFix.client.DTOs.UpdateCustomerDataForm

interface UpdateClient {
    fun execute(newData: UpdateCustomerDataForm): ClientView
}