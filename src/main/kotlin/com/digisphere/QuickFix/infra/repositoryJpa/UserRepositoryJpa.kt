package com.digisphere.QuickFix.infra.repositoryJpa

import com.digisphere.QuickFix.user.infra.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepositoryJpa : JpaRepository<UserEntity, Long>