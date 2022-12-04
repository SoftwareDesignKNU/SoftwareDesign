package auth.data.entity

data class LoginDTO(
    val emailOrUsername: String,
    val password: String,
)
