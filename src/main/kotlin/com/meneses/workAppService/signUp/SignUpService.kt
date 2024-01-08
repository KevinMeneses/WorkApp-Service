package com.meneses.workAppService.signUp

import com.meneses.workAppService.repository.user.User
import com.meneses.workAppService.repository.user.UserRepository

class SignUpService(
    private val userRepository: UserRepository = UserRepository()
) {
    fun register(signUpDTO: SignUpDTO): User {
        val user = User(
            username = signUpDTO.username,
            password = signUpDTO.password
        )

        return userRepository.createUser(user)
            ?: throw RuntimeException("User could not be created")
    }
}