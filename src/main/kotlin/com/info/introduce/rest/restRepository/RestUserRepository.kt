package com.info.introduce.rest.restRepository

import com.info.introduce.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface RestUserRepository : JpaRepository<User, String>