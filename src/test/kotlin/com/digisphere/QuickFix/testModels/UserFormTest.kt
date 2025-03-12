package com.digisphere.QuickFix.testModels

import com.digisphere.QuickFix.users.user.DTOs.UserForm
import com.digisphere.QuickFix.users.user.typeUsers.Type

object UserFormTest {
    fun build(): UserForm = UserForm(
        name = "Tony Stark",
        email = "tony@ironman.com",
        cpf = "8908789789",
        password = "senhaForte1234",
        phone = "89080890",
        type = Type.CLIENT,
    )

}
