import auth.data.UserRepository
import auth.presentation.*
import data.client.HttpClient
import data.database.Database
import kotlin.test.Test

class LoginTest {
     //T1 - UC7 - SDA1 Basic scenario
    @Test
    fun loginBasicTest() {
        val database = Database()
        val client = HttpClient()
        val userRepository = UserRepository(database, client)
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
     //T1.2 - UC7 - SDA1 Alternate scenario
    @Test
    fun loginFirstAlternativeFlowTest() {
        val database = Database()
        val client = HttpClient()
        val userRepository = UserRepository(database, client)
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
            password = "Qqwerty1"
        )
        component.reduce(LoginEvent.LoginButtonClickLoginEven)
    }
}