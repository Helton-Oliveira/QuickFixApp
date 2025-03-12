package com.digisphere.QuickFix.integrationTests

import br.com.alura.forum.configuration.DatabaseTestConfig
import com.digisphere.QuickFix.testModels.UserEntityTest
import com.digisphere.QuickFix.users.user.infra.repository.UserRepositoryImpl
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.testcontainers.junit.jupiter.Testcontainers
import org.junit.jupiter.api.Test

@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest: DatabaseTestConfig() {

    @Autowired
    lateinit var repository: UserRepositoryImpl
    private val entity = UserEntityTest.build()

    @Test
    fun `deve criar um usuario`() {
        val user = repository.persist(entity)

        assertThat(user.id).isNotNull()
    }

}