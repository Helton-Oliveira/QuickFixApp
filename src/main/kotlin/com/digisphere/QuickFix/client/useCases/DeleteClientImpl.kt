package com.digisphere.QuickFix.client.useCases

import com.digisphere.QuickFix.client.infra.entities.ClientEntity
import com.digisphere.QuickFix.infra.repository.GenericRepository

class DeleteClientImpl(private val repository: GenericRepository) : DeleteClient {
    override fun execute(id: Long): String {
        val clientExists = repository.deleteById<ClientEntity>(id)
        if (clientExists == null) throw RuntimeException("Erro ao deletar cliente. O id não existe.")
        return "Cliente com id: ${id} deletado com sucesso!"
    }
}