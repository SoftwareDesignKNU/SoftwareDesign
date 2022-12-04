package auth.login.presentation

sealed interface LoginEvent {
    value class UsernameChangeLoginEvent(val username: String) : LoginEvent
    value class RememberUsernameToggledLoginEvent(val rememberUser: Boolean) : LoginEvent
    value class PasswordForgotClickLoginEvent(val email: String) : LoginEvent
    object LoginButtonClickLoginEven : LoginEvent
    value class PasswordChangeLoginEvent(val password: String) : LoginEvent
    value class ConfirmEmailLoginEvent(val otp: String) : LoginEvent
    data class PasswordResetLoginEvent(val password: String, val confirmPassword: String) : LoginEvent
}