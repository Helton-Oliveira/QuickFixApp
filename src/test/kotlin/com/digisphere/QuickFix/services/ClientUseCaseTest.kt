package com.digisphere.QuickFix.services

import com.digisphere.QuickFix.client.DTOs.ClientForm
import com.digisphere.QuickFix.client.DTOs.UpdateCustomerDataForm
import com.digisphere.QuickFix.client.domain.Role
import com.digisphere.QuickFix.client.infra.repository.ClientRepository
import com.digisphere.QuickFix.client.infra.repository.ClientRepositoryInMemory
import com.digisphere.QuickFix.client.useCases.*
import com.digisphere.QuickFix.infra.connection.TestDatabaseAdapter
import org.assertj.core.api.Assertions.assertThat
import org.flywaydb.core.Flyway
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ClientUseCaseTest {
    private val connection = TestDatabaseAdapter()
    private val repository = ClientRepository(connection)
    private val repositoryFake = ClientRepositoryInMemory()
    private lateinit var clientForm1: ClientForm
    private val clientForm2 = ClientForm( name = "Steve Rogers", email = "Steve@avengers.com", cpf = "1234567890", password = "senha1234", role = Role.CLIENT)
    private val clientForm3 = ClientForm( name = "Tchalla", email = "Tchalla@avengers.com", cpf = "1234567890", password = "senha1234", role = Role.CLIENT)
    private lateinit var flyway: Flyway

    @BeforeEach
    fun setup() {
        flyway = Flyway.configure()
        .dataSource("jdbc:h2:mem:h2db;DB_CLOSE_DELAY=-1", "sa", "")
            .locations("classpath:db/migration")
            .load()
        flyway.migrate()
        clientForm1 = ClientForm( name = "Tony Stark", email = "Tony@avengers.com", cpf = "1234567890", password = "senha1234", role = Role.CLIENT)
        this.`deve criar um usuario`()
    }

    @Test
    fun `deve criar um usuario`() {
        val register = ClientRegisterImpl(repository)
        val client = register.execute(clientForm1)
        register.execute(clientForm2)
        register.execute(clientForm3)
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

    @Test
    fun `deve buscar usuarios`() {
        val finAllClients = FindAllClientsImpl(repository)
        val allClients = finAllClients.execute()
        assertThat(allClients.size).isNotNull()
        assertThat(allClients.size).isNotZero()
    }

    @Test
    fun `deve editar um usuario`() {
        val updateClient = UpdateClientImpl(repository)
        val newClient = UpdateCustomerDataForm(1, "Clark Kent", "clark@justice.com")
        val updatedClient = updateClient.execute(newClient)
        assertThat(updatedClient.id).isEqualTo(1)
        assertThat(updatedClient.name).isEqualTo("Clark Kent")
        assertThat(updatedClient.email).isEqualTo("clark@justice.com")
    }

    @Test
    fun `deve deletar um usuario`() {
        val deleteClient = DeleteClientImpl(repository)
        val deletedClient = deleteClient.execute(1)
        assertThat(deletedClient).isEqualTo("Cliente com id: 1 deletado com sucesso!")
    }

}