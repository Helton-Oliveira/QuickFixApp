package com.digisphere.QuickFix.testModels

import com.digisphere.QuickFix.users.user.domain.User
import com.digisphere.QuickFix.users.user.typeUsers.Type

object UserDomainTest {

    fun build() = User(
        name = "Tony Stark",
        email = "tony@ironman.com",
        cpf = "8908789789",
        password = "senhaForte1234",
        phone = "89080890",
        userType = Type.CLIENT,
    )
}
