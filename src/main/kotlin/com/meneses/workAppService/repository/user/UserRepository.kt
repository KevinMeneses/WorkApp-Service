package com.meneses.workAppService.repository.user

import com.meneses.workAppService.repository.city.City


class UserRepository {

    fun findUserByCredentials(username: String, password: String) =
        users.find { it.username == username && it.password == password }

    fun createUser(user: User) =
        users.add(user)

    fun findUserById(userId: String) =
        users.find { it.id == userId }

    private companion object {
        val users = mutableListOf(
            User(
                id = "0",
                username = "Kevin",
                password = "12345",
                city = City.POPAYAN
            )
        )
    }
}