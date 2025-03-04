package com.digisphere.QuickFix.infra.repository

interface GenericRepository {
    fun getAll(): List<Any>
    fun <Any> getById(id: Long): Any
    fun <Any> persist(entity: Any): Any
    fun <ID> deleteById(id: ID)
}