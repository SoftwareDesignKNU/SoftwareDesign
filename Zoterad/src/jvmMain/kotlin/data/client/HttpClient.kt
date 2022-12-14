package data.client

import auth.data.entity.LoginDTO
import auth.data.entity.RegisterDTO
import auth.data.entity.User
import collection.data.entity.ZoteroCollection
import kotlin.random.Random

typealias AuthToken = String

class HttpClient {
    private val libraries: MutableMap<User, Map<String, ZoteroCollection>> = mutableMapOf()
    private val authTokens = mutableSetOf<String>()
    private fun generateAuthToken(): String {
        var authToken: AuthToken
        do {
            authToken = List(25) { Random.nextInt(32, 126).toChar() }.joinToString("")
        } while (authTokens.contains(authToken))
        return authToken
    }
    private val users: MutableMap<RegisterDTO, AuthToken> = List(5) {
        RegisterDTO(
            firstName = "first name $it",
            lastName = "last name $it",
            email = "email$it",
            username = "username$it",
            password = "password$it"
        )
    }.associateWith { generateAuthToken() }.toMutableMap()

    fun login(loginDTO: LoginDTO): AuthToken? {
        println(users)
        val user = users.keys.find {
            it.email == loginDTO.emailOrUsername && it.password == loginDTO.password ||
                    it.username == loginDTO.emailOrUsername && it.password == loginDTO.password
        } ?: throw Exception("User not found")
        return users[user]
    }

    fun register(registerDTO: RegisterDTO): AuthToken? {
        if (users.keys.find { it.email == registerDTO.email } != null) throw Exception("Email already exists")
        if (users.keys.find { it.username == registerDTO.username } != null) throw Exception("Username already exists")
        users[registerDTO] = generateAuthToken()
        println(users)
        return users[registerDTO]
    }

    fun sendPasswordChangeRequest(email: String): String {
        if (users.keys.find { it.email == email } == null) throw Exception("User not found")
        println("Password confirmation send")
        return "otp generated"
    }

    fun sendPasswordConfirmation(otp: String) {
        if (otp == "otp generated") return
        throw Exception("OTPs are different")
    }

    fun changePassword(emailOrUsername: String, password: String): AuthToken {
        val user = users.keys.find { it.email == emailOrUsername } ?: throw Exception("User not found")
        val changedUser = user.copy(password = password)
        users.remove(user)
        val authToken = generateAuthToken()
        users[changedUser] = authToken
        return authToken
    }

    fun addLibraries(user: User, collections: Map<String, ZoteroCollection>) {
        libraries[user] = collections
    }

    fun getUser(emailOrUsername: String): User? {
        return users.keys.find { it.email == emailOrUsername || it.username == emailOrUsername }?.toUser()
    }
}