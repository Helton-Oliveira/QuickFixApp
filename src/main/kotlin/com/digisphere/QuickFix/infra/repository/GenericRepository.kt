package com.digisphere.QuickFix.infra.repository

interface GenericRepository {
    fun getAll(): List<Any>
    fun <ID> getById(id: ID): Any
    fun <Any> persist(entity: Any): Any
    fun <ID> deleteById(id: ID)
}