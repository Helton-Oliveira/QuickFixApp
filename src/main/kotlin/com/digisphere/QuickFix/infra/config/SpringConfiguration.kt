package com.digisphere.QuickFix.infra.config

import com.digisphere.QuickFix.client.infra.repository.ClientRepository
import com.digisphere.QuickFix.client.useCases.ClientRegister
import com.digisphere.QuickFix.client.useCases.ClientRegisterImpl
import com.digisphere.QuickFix.infra.connection.Connection
import com.digisphere.QuickFix.infra.connection.TestDatabaseAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfiguration {
    @Bean
    fun clientConnection(): Connection = TestDatabaseAdapter()

    @Bean
    fun registerClient(clientRepository: ClientRepository): ClientRegister = ClientRegisterImpl(clientRepository)

    @Bean
    fun clientRepository(connection: Connection): ClientRepository = ClientRepository(connection)
}