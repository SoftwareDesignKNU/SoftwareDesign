import auth.data.UserRepository
import auth.presentation.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class LoginTest {
    @Test
    fun loginBasicTest() {
        val userRepository = UserRepository()
        val registerComponent = RegisterComponent(userRepository)
        registerComponent.registerState = RegisterState(
            username = "example",
            email = "example@example.com",
            emailConfirm = "example@example.com",
            password = "Qqwerty1!",
            verifyPassword = "Qqwerty1!",
            firstName = "FirstName",
            lastName = "LastName"
        )
        registerComponent.reduce(RegisterEvent.RegistrationClickRegisterEvent)
        val component = LoginComponent(userRepository)
        component.loginState = LoginState(
            username = "example",
            password = "Qqwerty1!"
        )
        component.reduce(LoginEvent.LoginButtonClickLoginEven)
    }
}