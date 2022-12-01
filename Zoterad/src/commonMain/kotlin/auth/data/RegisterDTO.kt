package auth.data

data class RegisterDTO(
    val firstName: String,
    val lastName: String,
    val email: String,
    val username: String,
    val password: String
)
