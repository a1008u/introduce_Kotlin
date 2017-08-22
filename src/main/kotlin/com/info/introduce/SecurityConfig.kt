package com.info.introduce

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder

@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(web: WebSecurity?): Unit {
        web?.run({ ignoring().antMatchers("/webjars/**", "/css/**") })
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/loginForm").permitAll()
                .anyRequest().authenticated()
        .and()
            .formLogin()
            .loginProcessingUrl("/login")
            .loginPage("/loginForm")
            .failureUrl("/loginForm?error")
            .defaultSuccessUrl("/Top", true)
            .usernameParameter("UserNo").passwordParameter("password")
        .and()
            .logout()
            .logoutSuccessUrl("/loginForm")
    }

    @Bean
    internal fun passwordEncoder(): PasswordEncoder {
        return Pbkdf2PasswordEncoder()
    }
}