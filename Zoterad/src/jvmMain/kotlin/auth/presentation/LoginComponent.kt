package auth.presentation

import auth.data.entity.LoginDTO
import auth.domain.IUserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginComponent(
    private val userRepository: IUserRepository,
) {
    var loginState: LoginState = LoginState()
    fun reduce(loginEvent: LoginEvent) {
        CoroutineScope(Dispatchers.Unconfined).launch {
            when (loginEvent) {
                is LoginEvent.UsernameChangeLoginEvent -> {
                    loginState = loginState.copy(username = loginEvent.username)
                }
                LoginEvent.LoginButtonClickLoginEven -> {
                    println("LoginComponent: reduce(LoginButtonClickLoginEven)")
                    val loginDto = LoginDTO(loginState.username, loginState.password)
                    userRepository.login(loginDto)
                        .onSuccess {
                            println("Login successful")
                        }.onFailure {
                            it.printStackTrace()
                        }
                }
                is LoginEvent.PasswordChangeLoginEvent -> {
                    loginState = loginState.copy(password = loginEvent.password)
                }
                is LoginEvent.PasswordForgotClickLoginEvent -> {
                    println("LoginComponent: reduce(PasswordForgotClickLoginEvent)")
                    userRepository.sendPasswordChangeRequest(loginEvent.email)
                        .onSuccess {
                            println(it)
                            reduce(LoginEvent.ConfirmEmailLoginEvent(it, loginEvent.email, loginEvent.newPassword))
                        }.onFailure {
                            it.printStackTrace()
                        }
                }
                is LoginEvent.RememberUsernameToggledLoginEvent -> {
                    loginState = loginState.copy(rememberUser = loginEvent.rememberUser)
                }
                is LoginEvent.ConfirmEmailLoginEvent -> {
                    println("LoginComponent: reduce(ConfirmEmailLoginEvent)")
                    userRepository.sendPasswordConfirmation(loginEvent.otp)
                        .onSuccess {
                            reduce(LoginEvent.PasswordResetLoginEvent(loginEvent.newPassword, loginEvent.email))
                        }.onFailure {
                            it.printStackTrace()
                        }
                }
                is LoginEvent.PasswordResetLoginEvent -> {
                    println("LoginComponent: reduce(PasswordResetLoginEvent)")
                    if ("^(?=.*[A-Z])(?=.*[!@#\$&*])(?=.*\\d)(?=.*[a-z]).{8}\$\n".toRegex()
                            .matches(loginEvent.password)
                    ) {
                        println("Password is invalid")
                        return@launch
                    }
                    userRepository.changePassword(loginEvent.email, loginEvent.password)
                        .onSuccess {
                            println("Password successfully changed")
                        }.onFailure {
                            it.printStackTrace()
                        }
                }
            }
        }
    }
}