package data.database

import auth.data.entity.User
import collection.data.entity.ZoteroCollection

class Database {
    private val users: List<User> = List(100) {
        User(
            firstName = "first name $it",
            lastName = "last name $it",
            email = "email$it",
            username = "username$it"
        )
    }

    // locally there is only one user per session
    val libraries: MutableMap<String, ZoteroCollection> = mutableMapOf()

    var user: User? = null

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