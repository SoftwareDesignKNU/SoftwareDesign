package common.data.database

import auth.data.entity.User

class Database {
    private val users: List<User> = List(100) {
        User(
            firstName = "first name $it",
            lastName = "last name $it",
            email = "email$it",
            username = "username$it"
        )
    }

    fun getUserByEmail(email: String): User? {
        return users.find { it.email == email }
    }

    fun getUserByUsername(username: String): User? {
        return users.find { it.username == username }
    }

    fun getUsers(): List<User> {
        return users
    }
}