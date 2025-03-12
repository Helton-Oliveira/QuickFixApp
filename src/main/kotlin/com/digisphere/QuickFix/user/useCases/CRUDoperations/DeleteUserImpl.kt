package com.digisphere.QuickFix.user.useCases.CRUDoperations

class DeleteUserImpl(private val repository: com.digisphere.QuickFix.user.infra.repository.UserRepository) :
    DeleteUser {
    override fun execute(id: Long): String {
        val clientExists = repository.deleteById(id)
        if (clientExists == null) throw RuntimeException("Erro ao deletar cliente. O id não existe.")
        return "Cliente com id: ${id} deletado com sucesso!"
    }
}