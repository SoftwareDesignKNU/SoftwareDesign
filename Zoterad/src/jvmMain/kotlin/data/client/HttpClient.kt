package data.client

import auth.data.entity.LoginDTO
import auth.data.entity.RegisterDTO
import auth.data.entity.User
import collection.data.entity.ZoteroCollection
import kotlin.random.Random

typealias JWT = String

class HttpClient {
    private val users: MutableMap<RegisterDTO, JWT> = List(3) {
        RegisterDTO(
            firstName = "first name $it",
            lastName = "last name $it",
            email = "email$it",
            username = "username$it",
            password = "password$it"
        )
    }.associateWith { generateJWT(it.hashCode()) }.toMutableMap()
    private val libraries: MutableMap<User, Map<String, ZoteroCollection>> = mutableMapOf()
    private fun generateJWT(seed: Int): String {
        return List(25) { Random(seed).nextInt(32, 126).toChar() }.joinToString("")
    }

    fun login(loginDTO: LoginDTO): JWT? {
        println(users)
        val user = users.keys.find {
            it.email == loginDTO.emailOrUsername && it.password == loginDTO.password ||
                    it.username == loginDTO.emailOrUsername && it.password == loginDTO.password
        } ?: throw Exception("User not found")
        return users[user]
    }

    fun register(registerDTO: RegisterDTO): JWT? {
        if (users.keys.find { it.email == registerDTO.email } != null) throw Exception("Email already exists")
        if (users.keys.find { it.username == registerDTO.username } != null) throw Exception("Username already exists")
        users[registerDTO] = generateJWT(registerDTO.hashCode())
        println(users)
        return users[registerDTO]
    }

    fun sendPasswordChangeRequest(email: String): String {
        println("Password confirmation send")
        return "otp generated"
    }

    fun sendPasswordConfirmation(otp: String) {
        if (otp == "otp generated") return
        throw Exception("OTPs are different")
    }

    fun changePassword(email: String, password: String): JWT {
        val user = users.keys.find { it.email == email } ?: throw Exception("User not found")
        val changedUser = user.copy(password = password)
        users.remove(user)
        val jwt = generateJWT(changedUser.hashCode())
        users[changedUser] = jwt
        return jwt
    }

    fun addLibraries(user: User, collections: Map<String, ZoteroCollection>) {
        libraries[user] = collections
    }

    fun getUser(emailOrUsername: String): User? {
        return users.keys.find { it.email == emailOrUsername || it.username == emailOrUsername }?.toUser()
    }
}