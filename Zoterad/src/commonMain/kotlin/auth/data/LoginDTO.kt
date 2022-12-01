package auth.data

data class LoginDTO(
    val emailOrUsername: String,
    val password: String,
)
