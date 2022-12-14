package auth.presentation

import kotlin.jvm.JvmInline

sealed interface LoginEvent {
    @JvmInline
    value class UsernameChangeLoginEvent(val username: String) : LoginEvent

    @JvmInline
    value class RememberUsernameToggledLoginEvent(val rememberUser: Boolean) : LoginEvent

    data class PasswordForgotClickLoginEvent(val email: String, val newPassword: String) : LoginEvent
    object LoginButtonClickLoginEven : LoginEvent

    @JvmInline
    value class PasswordChangeLoginEvent(val password: String) : LoginEvent

    data class ConfirmEmailLoginEvent(val otp: String, val email: String, val newPassword: String) : LoginEvent
    data class PasswordResetLoginEvent(val password: String, val email: String) : LoginEvent
}