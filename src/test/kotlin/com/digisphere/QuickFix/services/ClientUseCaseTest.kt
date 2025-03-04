package com.digisphere.QuickFix.services

import com.digisphere.QuickFix.client.DTOs.ClientForm
import com.digisphere.QuickFix.client.domain.Role
import com.digisphere.QuickFix.client.infra.repository.ClientRepository
import com.digisphere.QuickFix.client.infra.repository.ClientRepositoryInMemory
import com.digisphere.QuickFix.client.useCases.ClientRegisterImpl
import com.digisphere.QuickFix.client.useCases.FindClientImpl
import com.digisphere.QuickFix.infra.connection.TestDatabaseAdapter
import org.assertj.core.api.Assertions.assertThat
import org.flywaydb.core.Flyway
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ClientUseCaseTest {
    private val connection = TestDatabaseAdapter()
    private val repository = ClientRepository(connection)
    private val repositoryFake = ClientRepositoryInMemory()
    private val clientForm = ClientForm( name = "Tony Stark", email = "Tony@avengers.com", cpf = "1234567890", password = "senha1234", role = Role.CLIENT)
    private lateinit var flyway: Flyway

    @BeforeEach
    fun setup() {
        flyway = Flyway.configure()
        .dataSource("jdbc:h2:mem:h2db;DB_CLOSE_DELAY=-1", "sa", "")
            .locations("classpath:db/migration")
            .load()
        flyway.migrate()
    }

    @Test
    fun `deve criar um usuario`() {
        val register = ClientRegisterImpl(repository)
        val client = register.execute(clientForm)
        assertThat(client.name).isEqualTo("Tony Stark")
        assertThat(client.email).isEqualTo("Tony@avengers.com")
        assertThat(client.cpf).isEqualTo("1234567890")
    }

    @Test
    fun `deve buscar um usuario`() {
        val finClient = FindClientImpl(repository)
        val client = finClient.execute(1L)
        assertThat(client.name).isEqualTo("Tony Stark")
        assertThat(client.email).isEqualTo("Tony@avengers.com")
        assertThat(client.cpf).isEqualTo("1234567890")
    }

}