package auth.presentation

class LoginComponent {
    var loginState: LoginState = LoginState()
    fun reduce(loginEvent: LoginEvent) {
        when (loginEvent) {
            is LoginEvent.UsernameChangeLoginEvent -> {
                loginState = loginState.copy(username = loginEvent.username)
            }
        }
    }
}