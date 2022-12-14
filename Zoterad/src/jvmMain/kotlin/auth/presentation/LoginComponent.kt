package auth.presentation

import auth.data.UserRepository
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
                    userRepository.sendPasswordChangeRequest(loginEvent.email).onSuccess {
                        reduce(LoginEvent.ConfirmEmailLoginEvent(it))
                    }
                }
                is LoginEvent.RememberUsernameToggledLoginEvent -> {
                    loginState = loginState.copy(rememberUser = loginEvent.rememberUser)
                }
                is LoginEvent.ConfirmEmailLoginEvent -> {
                    userRepository.sendPasswordConfirmation(loginEvent.otp)
                    reduce(LoginEvent.PasswordResetLoginEvent(loginState.password))
                }
                is LoginEvent.PasswordResetLoginEvent -> {
                    userRepository.changePassword(loginState.username, loginEvent.password)
                }
            }
        }
    }
}