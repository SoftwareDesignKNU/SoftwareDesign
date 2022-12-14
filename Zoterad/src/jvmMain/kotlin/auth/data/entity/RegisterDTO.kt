package auth.data.entity

data class RegisterDTO(
    val firstName: String,
    val lastName: String,
    val email: String,
    val username: String,
    val password: String
) {
    fun toUser() = User(
        email = email,
        firstName = firstName,
        lastName = lastName,
        username = username
    )
}
