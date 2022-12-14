package auth.register.presentation

data class RegisterState(
    val username: String = "",
    val email: String = "",
    val emailConfirm: String = "",
    val password: String = "",
    val verifyPassword: String = "",
    val firstName: String = "",
    val lastName: String = ""
)
