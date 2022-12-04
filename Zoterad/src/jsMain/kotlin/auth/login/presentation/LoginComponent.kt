package auth.login.presentation

import auth.domain.IUserRepository

class LoginComponent(
    private val userRepository: IUserRepository,
) {
    var loginState: LoginState = LoginState()
    fun reduce(loginEvent: LoginEvent) {
        when (loginEvent) {
            is LoginEvent.UsernameChangeLoginEvent -> {
                loginState = loginState.copy(username = loginEvent.username)
            }
            LoginEvent.LoginButtonClickLoginEven -> {
                // login logic is executed
            }
            is LoginEvent.PasswordChangeLoginEvent -> {
                loginState = loginState.copy(password = loginEvent.password)
            }
            is LoginEvent.PasswordForgotClickLoginEvent -> {
                // Password forgot dialog opens
            }
            is LoginEvent.RememberUsernameToggledLoginEvent -> {
                loginState = loginState.copy(rememberUser = loginEvent.rememberUser)
            }
            is LoginEvent.ConfirmEmailLoginEvent -> {
                // user goes using confirmation link
            }
            is LoginEvent.PasswordResetLoginEvent -> {
                // user changes passwords
            }
        }
    }
}