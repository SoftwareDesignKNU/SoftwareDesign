package data.database

import auth.data.entity.User
import collection.data.entity.ZoteroCollection
import item.data.entity.item.Book
import item.data.entity.item.BookRelatedSubData
import item.data.entity.item.ItemSubData

class Database {
    private val users: List<User> = List(3) {
        User(
            firstName = "first name $it",
            lastName = "last name $it",
            email = "email$it",
            username = "username$it"
        )
    }

    // locally there is only one user per session
    val libraries: List<ZoteroCollection> = mutableListOf(
        ZoteroCollection(
            title = "Differential Geometry",
            items = mutableListOf(
                Book(
                    bookRelatedSubData = BookRelatedSubData(
                        itemSubData = ItemSubData(
                            title = "Differential Geometry"
                        )
                    )
                )
            )
        )
    )

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