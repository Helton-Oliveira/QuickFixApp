package com.digisphere.QuickFix.infra.config

import com.digisphere.QuickFix.users.user.useCases.UserRegister
import com.digisphere.QuickFix.users.user.useCases.UserRegisterImpl
import com.digisphere.QuickFix.user.infra.repository.UserRepository
import com.digisphere.QuickFix.users.user.useCases.FindUserById
import com.digisphere.QuickFix.users.user.useCases.FindUserByIdImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SpringConfiguration {
/*    @Bean
    fun userRepository(): UserRepositoryImpl = UserRepositoryImpl()*/

    @Bean
    fun registerClient(userRepository: com.digisphere.QuickFix.user.infra.repository.UserRepository): UserRegister = UserRegisterImpl(userRepository)

    @Bean
    fun findClient(userRepository: com.digisphere.QuickFix.user.infra.repository.UserRepository): FindUserById = FindUserByIdImpl(userRepository)
}