package com.meneses.workAppService.repository.user

import com.meneses.workAppService.repository.city.City

data class User(
    val id: String? = null,
    val username: String,
    val password: String,
    val city: City? = null,
    val firstname: String? = null,
    val lastname: String? = null,
    val email: String? = null,
    val phone: String? = null,
    val rating: String? = null,
    val address: String? = null
)
