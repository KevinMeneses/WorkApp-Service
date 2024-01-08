package com.meneses.workAppService.login

import com.meneses.workAppService.login.security.Token
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController(
    private val loginService: LoginService = LoginService()
) {

    @PostMapping("/authenticate")
    fun authenticate(@RequestBody loginDTO: LoginDTO): Token? =
        loginService.authenticate(loginDTO)
}