package com.digisphere.QuickFix.infra.config

import com.digisphere.QuickFix.user.useCases.CRUDoperations.FindUserById
import com.digisphere.QuickFix.user.useCases.CRUDoperations.FindUserByIdImpl
import com.digisphere.QuickFix.user.useCases.CRUDoperations.UserRegister
import com.digisphere.QuickFix.user.useCases.CRUDoperations.UserRegisterImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SpringConfiguration {

    @Bean
    fun registerClient(userRepository: com.digisphere.QuickFix.user.infra.repository.UserRepository): UserRegister = UserRegisterImpl(userRepository)

    @Bean
    fun findClient(userRepository: com.digisphere.QuickFix.user.infra.repository.UserRepository): FindUserById = FindUserByIdImpl(userRepository)
}