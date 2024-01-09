package com.meneses.workAppService.users

import com.meneses.workAppService.repository.user.UserRepository

class UserProfileService(
    private val userRepository: UserRepository = UserRepository()
) {
    fun getUserProfile(userId: String) =
        userRepository.findUserById(userId)
}