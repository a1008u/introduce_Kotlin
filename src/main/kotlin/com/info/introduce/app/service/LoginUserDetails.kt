package com.info.introduce.app.service

import com.info.introduce.entity.User
import org.springframework.security.core.authority.AuthorityUtils


class LoginUserDetails(user: User) : org.springframework.security.core.userdetails.User(
          user.userno
        , user.encodedPassword
        , AuthorityUtils.createAuthorityList("ROLE_USER")) {

    private val serialVersionUID = 1L

    var loginUser: User? = null
    init{  this.loginUser = user  }
}