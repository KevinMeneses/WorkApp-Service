package com.meneses.workAppService.login.security

import com.meneses.workAppService.repository.user.User

typealias Token = String

class JwtProvider {
    fun createToken(user: User): Token {
        return "TODO: generate JWT token"
    }
}