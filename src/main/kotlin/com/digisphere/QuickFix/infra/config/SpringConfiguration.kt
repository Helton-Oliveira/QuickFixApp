package com.digisphere.QuickFix.infra.config

import com.digisphere.QuickFix.users.infra.repository.ClientRepository
import com.digisphere.QuickFix.users.useCases.UserRegister
import com.digisphere.QuickFix.users.useCases.UserRegisterImpl
import com.digisphere.QuickFix.users.useCases.FindUserById
import com.digisphere.QuickFix.users.useCases.FindUserByIdImpl
import com.digisphere.QuickFix.infra.connection.Connection
import com.digisphere.QuickFix.infra.connection.TestDatabaseAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfiguration {
    @Bean
    fun clientConnection(): Connection = TestDatabaseAdapter()

    @Bean
    fun registerClient(clientRepository: ClientRepository): UserRegister = UserRegisterImpl(clientRepository)

    @Bean
    fun findClient(clientRepository: ClientRepository): FindUserById = FindUserByIdImpl(clientRepository)

    @Bean
    fun clientRepository(connection: Connection): ClientRepository = ClientRepository(connection)
}