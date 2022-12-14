package auth.presentation

data class LoginState(
    val username: String = "",
    val password: String = "",
    val rememberUser: Boolean = false,
)
