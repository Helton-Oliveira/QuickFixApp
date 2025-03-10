package com.digisphere.QuickFix.infra.config

import com.digisphere.QuickFix.users.sharedResources.infra.repository.UserRepository
import com.digisphere.QuickFix.users.clientUser.useCases.UserRegister
import com.digisphere.QuickFix.users.clientUser.useCases.UserRegisterImpl
import com.digisphere.QuickFix.users.sharedResources.sharedUseCases.FindUserById
import com.digisphere.QuickFix.users.sharedResources.sharedUseCases.FindUserByIdImpl
import com.digisphere.QuickFix.infra.connection.Connection
import com.digisphere.QuickFix.infra.connection.TestDatabaseAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfiguration {
    @Bean
    fun clientConnection(): Connection = TestDatabaseAdapter()

    @Bean
    fun registerClient(userRepository: UserRepository): UserRegister = UserRegisterImpl(userRepository)

    @Bean
    fun findClient(userRepository: UserRepository): FindUserById = FindUserByIdImpl(userRepository)

    @Bean
    fun clientRepository(connection: Connection): UserRepository = UserRepository(connection)
}