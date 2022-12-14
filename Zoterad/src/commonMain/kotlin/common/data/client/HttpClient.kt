package common.data.client

import auth.data.entity.LoginDTO
import auth.data.entity.RegisterDTO
import kotlin.random.Random

class HttpClient {
    private val users: MutableMap<RegisterDTO, String> = List(100) {
        RegisterDTO(
            firstName = "first name $it",
            lastName = "last name $it",
            email = "email$it",
            username = "username$it",
            password = "password$it"
        )
    }.associateWith { generateJWT(it.hashCode()) }.toMutableMap()

    private fun generateJWT(seed: Int): String {
        return List(25) { Random(seed).nextInt(32, 126).toChar() }.joinToString("")
    }

    fun login(loginDTO: LoginDTO): String? {
        val user = users.keys.find {
            it.email == loginDTO.emailOrUsername && it.password == loginDTO.password ||
                    it.username == loginDTO.emailOrUsername && it.password == loginDTO.password
        } ?: return null
        return users[user]
    }

    fun register(registerDTO: RegisterDTO): String? {
        users[registerDTO] = generateJWT(registerDTO.hashCode())
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

    fun changePassword(email: String, password: String): String {
        val user = users.keys.find { it.email == email } ?: throw Exception("User not found")
        val changedUser = user.copy(password = password)
        users.remove(user)
        val jwt = generateJWT(changedUser.hashCode())
        users[changedUser] = jwt
        return jwt
    }
}