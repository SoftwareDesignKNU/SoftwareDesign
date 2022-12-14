package auth.login.presentation

import auth.data.UserRepository
import auth.data.entity.LoginDTO
import auth.domain.IUserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginComponent(
    private val userRepository: IUserRepository = UserRepository(),
) {
    var loginState: LoginState = LoginState()
    fun reduce(loginEvent: LoginEvent) {
        CoroutineScope(Dispatchers.Default).launch {
            when (loginEvent) {
                is LoginEvent.UsernameChangeLoginEvent -> {
                    loginState = loginState.copy(username = loginEvent.username)
                }
                LoginEvent.LoginButtonClickLoginEven -> {
                    val loginDto = LoginDTO(loginState.username, loginState.password)
                    userRepository.login(loginDto)
                    println("Screen was changed to the main screen")
                }
                is LoginEvent.PasswordChangeLoginEvent -> {
                    loginState = loginState.copy(password = loginEvent.password)
                }
                is LoginEvent.PasswordForgotClickLoginEvent -> {
                    val otpResult = userRepository.sendPasswordChangeRequest(loginEvent.email).getOrNull()
                    otpResult?.let {
                        reduce(LoginEvent.ConfirmEmailLoginEvent(otpResult))

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