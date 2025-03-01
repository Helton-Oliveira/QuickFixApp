package com.digisphere.QuickFix.infra.config

import com.digisphere.QuickFix.infra.connection.Connection
import com.digisphere.QuickFix.infra.connection.ConnectionImpl
import com.digisphere.QuickFix.client.useCases.ClientRegister
import com.digisphere.QuickFix.client.useCases.ClientRegisterImpl
import com.digisphere.QuickFix.client.infra.repository.ClientRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfiguration {
    @Bean
    fun connection(): Connection = ConnectionImpl

    @Bean
    fun registerClient(clientRepository: ClientRepository): ClientRegister = ClientRegisterImpl(clientRepository)

    @Bean
    fun clientRepository(connection: Connection): ClientRepository = ClientRepository(connection.createTestDatabase())
}