package auth.presentation

import kotlin.jvm.JvmInline

sealed interface RegisterEvent {
    @JvmInline
    value class UsernameChangeRegisterEvent(val username: String) : RegisterEvent
    @JvmInline
    value class EmailConfirmChangeRegisterEvent(val emailConfirm: String) : RegisterEvent
    @JvmInline
    value class PasswordChangeRegisterEvent(val password: String) : RegisterEvent
    @JvmInline
    value class EmailChangeRegisterEvent(val email: String) : RegisterEvent
    @JvmInline
    value class PasswordVerificationChangeRegisterEvent(val passwordConfirmation: String) : RegisterEvent
    object RegistrationClickRegisterEvent : RegisterEvent 
}