package com.digisphere.QuickFix.services

import com.digisphere.QuickFix.users.DTOs.UserForm
import com.digisphere.QuickFix.users.DTOs.UpdateCustomerDataForm
import com.digisphere.QuickFix.users.domain.Role
import com.digisphere.QuickFix.users.infra.repository.ClientRepository
import com.digisphere.QuickFix.users.infra.repository.ClientRepositoryInMemory
import com.digisphere.QuickFix.users.useCases.*
import com.digisphere.QuickFix.infra.connection.TestDatabaseAdapter
import org.assertj.core.api.Assertions.assertThat
import org.flywaydb.core.Flyway
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UserUseCaseTest {
    private val connection = TestDatabaseAdapter()
    private val repository = ClientRepository(connection)
    private val repositoryFake = ClientRepositoryInMemory()
    private lateinit var userForm1: UserForm
    private val userForm2 = UserForm( name = "Steve Rogers", email = "Steve@avengers.com", cpf = "1234567890", password = "senha1234", role = Role.CLIENT)
    private val userForm3 = UserForm( name = "Tchalla", email = "Tchalla@avengers.com", cpf = "1234567890", password = "senha1234", role = Role.CLIENT)
    private lateinit var flyway: Flyway

    @BeforeEach
    fun setup() {
        flyway = Flyway.configure()
        .dataSource("jdbc:h2:mem:h2db;DB_CLOSE_DELAY=-1", "sa", "")
            .locations("classpath:db/migration")
            .load()
        flyway.migrate()
        userForm1 = UserForm( name = "Tony Stark", email = "Tony@avengers.com", cpf = "1234567890", password = "senha1234", role = Role.CLIENT)
        this.`deve criar um usuario`()
    }

    @Test
    fun `deve criar um usuario`() {
        val register = UserRegisterImpl(repository)
        val client = register.execute(userForm1)
        register.execute(userForm2)
        register.execute(userForm3)
        assertThat(client.name).isEqualTo("Tony Stark")
        assertThat(client.email).isEqualTo("Tony@avengers.com")
        assertThat(client.cpf).isEqualTo("1234567890")
    }

    @Test
    fun `deve buscar um usuario`() {
        val finClient = FindUserByIdImpl(repository)
        val client = finClient.execute(1L)
        assertThat(client.name).isEqualTo("Tony Stark")
        assertThat(client.email).isEqualTo("Tony@avengers.com")
        assertThat(client.cpf).isEqualTo("1234567890")
    }

    @Test
    fun `deve buscar usuarios`() {
        val finAllClients = FindAllUsersImpl(repository)
        val allClients = finAllClients.execute()
        assertThat(allClients.size).isNotNull()
        assertThat(allClients.size).isNotZero()
    }

    @Test
    fun `deve editar um usuario`() {
        val updateClient = UpdateUserImpl(repository)
        val newClient = UpdateCustomerDataForm(1, "Clark Kent", "clark@justice.com")
        val updatedClient = updateClient.execute(newClient)
        assertThat(updatedClient.id).isEqualTo(1)
        assertThat(updatedClient.name).isEqualTo("Clark Kent")
        assertThat(updatedClient.email).isEqualTo("clark@justice.com")
    }

    @Test
    fun `deve deletar um usuario`() {
        val deleteClient = DeleteUserImpl(repository)
        val deletedClient = deleteClient.execute(1)
        assertThat(deletedClient).isEqualTo("Cliente com id: 1 deletado com sucesso!")
    }

}