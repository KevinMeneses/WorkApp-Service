package com.meneses.workAppService.users.dto

import com.meneses.workAppService.repository.city.City

data class UserDTO(
    val id: String,
    val username: String? = null,
    val password: String? = null,
    val city: City? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val rating: Float? = null,
    val address: String? = null
)
