package com.digisphere.QuickFix.client.infra.repository

import com.digisphere.QuickFix.client.infra.entities.ClientEntity
import com.digisphere.QuickFix.infra.connection.Connection
import com.digisphere.QuickFix.infra.repository.GenericRepositoryImpl

class ClientRepository(manager: Connection)
    : GenericRepositoryImpl<ClientEntity>(manager, ClientEntity::class.java)