package com.info.introduce.app.repository

import com.info.introduce.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String>
