package com.digisphere.QuickFix.UnitTests

import com.digisphere.QuickFix.users.user.domain.User
import com.digisphere.QuickFix.users.user.typeUsers.Type
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class UserTest {

    @Test
    fun `deve criptografar senha do usuario criado`() {
        val user = User(cpf = "2323232", name = "Tony Stark", email = "stark@ironman.com", password = "senhaForte1234", phone = "234324324", userType = Type.CLIENT)
        user.passwordEncoder()
        assertThat(BCryptPasswordEncoder().matches("senhaForte1234", user.passwordHash)).isTrue()
    }
}