package com.meneses.workAppService.repository.user

import com.meneses.workAppService.repository.city.City

data class User(
    val id: String? = null,
    val username: String,
    val password: String,
    val city: City? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val rating: Float? = null,
    val address: String? = null
)
