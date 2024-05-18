package com.meneses.workAppService.users

import com.meneses.workAppService.repository.user.UserRepository
import com.meneses.workAppService.users.dto.UserDTO

class UserProfileService(
    private val userRepository: UserRepository = UserRepository()
) {
    fun getUserProfile(userId: String) =
        userRepository.findUserById(userId)

    fun updateUserProfile(userDTO: UserDTO): Boolean {
        val user = userRepository.findUserById(userDTO.id)
            ?: throw RuntimeException("User not found")

        val updatedUser = user.copy(
            username = userDTO.username ?: user.username,
            password = userDTO.password ?: user.password,
            city = userDTO.city ?: user.city,
            firstName = userDTO.firstName ?: user.firstName,
            lastName = userDTO.lastName ?: user.lastName,
            email = userDTO.email ?: user.email,
            phoneNumber = userDTO.phoneNumber ?: user.phoneNumber,
            rating = userDTO.rating ?: user.rating,
            address = userDTO.address ?: user.address
        )

        return userRepository.updateUser(updatedUser)
    }
}