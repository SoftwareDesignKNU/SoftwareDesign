package auth.register.presentation

import auth.domain.IUserRepository

class RegisterComponent(
    private val userRepository: IUserRepository,
) {
    var registerState = RegisterState()
    fun reduce(registerEvent: RegisterEvent) {
        when (registerEvent) {
            is RegisterEvent.EmailChangeRegisterEvent -> {
                registerState = registerState.copy(email = registerEvent.email)
            }
            is RegisterEvent.EmailConfirmChangeRegisterEvent -> {
                registerState = registerState.copy(emailConfirm = registerEvent.emailConfirm)
            }
            is RegisterEvent.PasswordChangeRegisterEvent -> {
                registerState = registerState.copy(password = registerEvent.password)
            }
            is RegisterEvent.PasswordVerificationChangeRegisterEvent -> {
                registerState = registerState.copy(verifyPassword = registerEvent.passwordConfirmation)
            }
            RegisterEvent.RegistrationClickRegisterEvent -> {
                // login logic
            }
            is RegisterEvent.UsernameChangeRegisterEvent -> {
                registerState = registerState.copy(username = registerEvent.username)
            }
        }
    }
}