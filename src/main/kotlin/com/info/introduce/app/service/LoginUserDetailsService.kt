package com.info.introduce.app.service

import com.info.introduce.app.repository.UserRepository
import com.info.introduce.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class LoginUserDetailsService : UserDetailsService {

    @Autowired
    internal var userRepository: UserRepository? = null

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(UserNo: String): UserDetails {
        val user = userRepository?.run { findOne(UserNo) ?: throw UsernameNotFoundException("The requested user is not found.") }

        return LoginUserDetails(user as User)
    }
}