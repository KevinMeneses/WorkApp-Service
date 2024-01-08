package com.meneses.workAppService.login

import com.meneses.workAppService.login.security.JwtProvider
import com.meneses.workAppService.login.security.Token
import com.meneses.workAppService.repository.user.UserRepository


class LoginService(
    private val userRepository: UserRepository = UserRepository(),
    private val jwtProvider: JwtProvider = JwtProvider()
) {
    fun authenticate(loginDTO: LoginDTO): Token {
        val user = userRepository
            .findUserByCredentials(loginDTO.username, loginDTO.password)
            ?: throw RuntimeException("Invalid credentials")

        return jwtProvider.createToken(user)
    }
}