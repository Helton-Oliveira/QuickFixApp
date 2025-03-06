package com.digisphere.QuickFix.infra.repository

interface GenericRepository {
    fun <Any> getAll(): List<Any>
    fun <Any> getById(id: Long): Any
    fun <Any> persist(entity: Any): Any
    fun <Any> deleteById(id: Long): Any
}