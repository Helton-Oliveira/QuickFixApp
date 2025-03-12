package com.digisphere.QuickFix.testModels

import com.digisphere.QuickFix.user.infra.entities.UserEntity
import com.digisphere.QuickFix.users.user.typeUsers.Type

object UserEntityTest {
    fun build() = com.digisphere.QuickFix.user.infra.entities.UserEntity(
        fullName = "Tony Stark",
        passwordHash = "senhaForte1234",
        phone = "89080890",
        email = "tony@ironman.com",
        cpf = "8908789789",
        userType = Type.CLIENT
    )
}