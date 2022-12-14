package auth.presentation

import auth.data.entity.RegisterDTO
import auth.domain.IUserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
                CoroutineScope(Dispatchers.Unconfined).launch {
                    println("Register component: reduce(RegistrationClickRegisterEvent)")
                    if (registerState.validateData()) {
                        println("Data is all valid")
                        userRepository.register(
                            RegisterDTO(
                                firstName = registerState.firstName,
                                lastName = registerState.lastName,
                                email = registerState.email,
                                password = registerState.password,
                                username = registerState.username
                            )
                        ).onSuccess {
                            println("Register success")
                        }.onFailure {
                            println("Register error")
                        }
                    } else {
                        println("Data is invalid(")
                    }
                }
            }
            is RegisterEvent.UsernameChangeRegisterEvent -> {
                registerState = registerState.copy(username = registerEvent.username)
            }
        }
    }
}

