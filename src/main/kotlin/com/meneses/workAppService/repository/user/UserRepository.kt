package com.meneses.workAppService.repository.user

import com.meneses.workAppService.repository.city.City


class UserRepository {

    fun findUserByCredentials(username: String, password: String) =
        users.find { it.username == username && it.password == password }

    fun createUser(user: User) : User? =
        user.takeIf { users.add(it) }

    private companion object {
        val users = mutableListOf(
            User(
                username = "Kevin",
                password = "12345",
                city = City.POPAYAN
            )
        )
    }
}