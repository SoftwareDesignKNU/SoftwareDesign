package auth.register.presentation

sealed interface RegisterEvent {
    value class UsernameChangeRegisterEvent(val username: String) : RegisterEvent
    value class EmailConfirmChangeRegisterEvent(val emailConfirm: String) : RegisterEvent
    value class PasswordChangeRegisterEvent(val password: String) : RegisterEvent
    value class EmailChangeRegisterEvent(val email: String) : RegisterEvent
    value class PasswordVerificationChangeRegisterEvent(val passwordConfirmation: String) : RegisterEvent
    object RegistrationClickRegisterEvent : RegisterEvent
}