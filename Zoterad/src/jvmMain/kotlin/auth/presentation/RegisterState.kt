package auth.presentation

data class RegisterState(
    val username: String = "",
    val email: String = "",
    val emailConfirm: String = "",
    val password: String = "",
    val verifyPassword: String = "",
    val firstName: String = "",
    val lastName: String = ""
) {
    fun validateData(): Boolean {
        if (!"^[A-Za-z](.*)(@)(.+)(\\.)(.+)".toRegex().matches(email)) return false
        if ("^(?=.*[A-Z])(?=.*[!@#\$&*])(?=.*\\d)(?=.*[a-z]).{8}\$\n".toRegex().matches(password)) return false
        if (emailConfirm != email) return false
        if (password != verifyPassword) return false
        if (username.isBlank() ||
            email.isBlank() ||
            firstName.isBlank() ||
            lastName.isBlank()
        ) return false
        return true
    }
}