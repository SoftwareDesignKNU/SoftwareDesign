package auth.presentation

import kotlin.jvm.JvmInline

sealed interface LoginEvent {
    @JvmInline
    value class UsernameChangeLoginEvent(val username: String) : LoginEvent

    @JvmInline
    value class RememberUsernameToggledLoginEvent(val rememberUser: Boolean) : LoginEvent

    @JvmInline
    value class PasswordForgotClickLoginEvent(val email: String) : LoginEvent
    object LoginButtonClickLoginEven : LoginEvent

    @JvmInline
    value class PasswordChangeLoginEvent(val password: String) : LoginEvent

    @JvmInline
    value class ConfirmEmailLoginEvent(val otp: String) : LoginEvent
    data class PasswordResetLoginEvent(val password: String) : LoginEvent
}