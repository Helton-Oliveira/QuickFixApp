package com.digisphere.QuickFix.users.useCases

import com.digisphere.QuickFix.users.infra.entities.UserEntity
import com.digisphere.QuickFix.infra.repository.GenericRepository

class DeleteUserImpl(private val repository: GenericRepository) : DeleteUser {
    override fun execute(id: Long): String {
        val clientExists = repository.deleteById<UserEntity>(id)
        if (clientExists == null) throw RuntimeException("Erro ao deletar cliente. O id não existe.")
        return "Cliente com id: ${id} deletado com sucesso!"
    }
}