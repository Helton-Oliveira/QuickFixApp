package com.digisphere.QuickFix.user.infra.repository

import com.digisphere.QuickFix.infra.repositoryJpa.UserRepositoryJpa
import com.digisphere.QuickFix.user.infra.entities.UserEntity
import com.digisphere.QuickFix.user.infra.entities.util.toViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {

    @Autowired
    private lateinit var repository: UserRepositoryJpa

    override fun getAll(): List<UserEntity> {
        return repository.findAll()
    }

    override fun getById(id: Long): UserEntity {
        val entity = repository.findById(id)
        if(!entity.isPresent) throw RuntimeException("Not Found!")
        return entity.get()
    }

    override fun persist(entity: UserEntity): UserEntity {
        return repository.save(entity)
    }

    override fun deleteById(id: Long): Long {
        val isExist = repository.existsById(id)
        if (isExist) {
            val entityId =  repository.findById(id).get().toViewModel().id
            repository.deleteById(id)
            return entityId
        }
        throw RuntimeException("Not Found!")
    }
}