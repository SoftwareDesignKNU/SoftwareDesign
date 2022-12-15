package data.database

import auth.data.entity.User
import collection.data.entity.ZoteroCollection
import item.data.entity.item.ZoteroItem

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
    val libraries: MutableList<ZoteroCollection> = mutableListOf(
        ZoteroCollection(
            title = "Differential Geometry",
            items = mutableListOf(
                ZoteroItem.ComplexZoteroItem(
                    hashMapOf(
                        "title" to ZoteroItem.SimpleZoteroItem("Differential Geometry"),
                        "language" to ZoteroItem.SimpleZoteroItem("English"),
                        "people" to ZoteroItem.ComplexZoteroItem(
                            hashMapOf(
                                "author" to ZoteroItem.SimpleZoteroItem("Arystan"),
                                "helper" to ZoteroItem.SimpleZoteroItem("Shokan")
                            )
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