package com.digisphere.QuickFix.services

import com.digisphere.QuickFix.testModels.UserEntityTest
import com.digisphere.QuickFix.testModels.UserFormTest
import com.digisphere.QuickFix.user.DTOs.UpdateCustomerDataForm
import com.digisphere.QuickFix.user.infra.repository.UserRepositoryImpl
import com.digisphere.QuickFix.user.useCases.CRUDoperations.*
import io.mockk.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserUseCaseTest {

    private val entityModelTest = UserEntityTest.build()
    private val userFormTest = UserFormTest.build()
    private val  repository: UserRepositoryImpl = mockk{
        every { persist(any()) } returns entityModelTest
        every { getAll() } returns listOf(entityModelTest)
        every { getById(any()) } returns entityModelTest
        every { deleteById(any()) } returns 1L
    }

    @Test
    fun `deve executar caso de uso para registrar usuario`() {
        val register = UserRegisterImpl(repository)
        val client = register.execute(userFormTest)

        assertThat(client.name).isEqualTo("Tony Stark")
        assertThat(client.email).isEqualTo("tony@ironman.com")
        assertThat(client.cpf).isEqualTo("8908789789")

        verify (exactly = 1) { repository.persist(any())}
    }

    @Test
    fun `deve executar a busca de um usuario pelo caso de uso`() {
        val finClient = FindUserByIdImpl(repository)
        val client = finClient.execute(1L)

        assertThat(client.name).isEqualTo("Tony Stark")
        assertThat(client.email).isEqualTo("tony@ironman.com")
        assertThat(client.cpf).isEqualTo("8908789789")

        verify(exactly = 1) { repository.getById(any()) }
    }

    @Test
    fun `deve executar a busca por todos os usuarios pelo caso de uso`() {
        val finAllClients = FindAllUsersImpl(repository)
        val allClients = finAllClients.execute()
        assertThat(allClients.size).isNotNull()
        assertThat(allClients.size).isNotZero()
    }

    @Test
    fun `deve executar a edicao de um usuario pelo caso de uso `() {
        val updateClient = UpdateUserImpl(repository)
        val newClient = UpdateCustomerDataForm(1, "Clark Kent", "clark@justice.com")
        val updatedClient = updateClient.execute(newClient)
        assertThat(updatedClient.id).isEqualTo(1)
        assertThat(updatedClient.name).isEqualTo("Clark Kent")
        assertThat(updatedClient.email).isEqualTo("clark@justice.com")
    }

    @Test
    fun `deve executar a delecao de um usuario pelo caso de uso`() {
        val deleteClient = DeleteUserImpl(repository)
        val deletedClient = deleteClient.execute(1)
        assertThat(deletedClient).isEqualTo("Cliente com id: 1 deletado com sucesso!")
    }
}