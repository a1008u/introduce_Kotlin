package com.info.introduce.app.controller


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {

    @GetMapping(path = arrayOf("loginForm"))
    internal fun loginForm(): String {
        return "logingate/LoginForm"
    }

}