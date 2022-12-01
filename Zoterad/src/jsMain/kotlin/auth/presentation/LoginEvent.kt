package auth.presentation

sealed class LoginEvent {
    data class UsernameChangeLoginEvent(val username: String) : LoginEvent()

}