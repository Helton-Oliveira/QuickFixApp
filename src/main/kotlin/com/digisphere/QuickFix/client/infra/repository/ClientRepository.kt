package com.digisphere.QuickFix.client.infra.repository

import com.digisphere.QuickFix.client.infra.entities.ClientEntity
import com.digisphere.QuickFix.infra.repository.GenericRepositoryImpl
import jakarta.persistence.EntityManager

class ClientRepository(manager: EntityManager) : GenericRepositoryImpl<ClientEntity, String>(manager, ClientEntity::class.java)