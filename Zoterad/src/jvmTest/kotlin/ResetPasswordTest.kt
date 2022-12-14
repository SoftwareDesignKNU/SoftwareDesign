import auth.data.UserRepository
import auth.presentation.*
import data.client.HttpClient
import data.database.Database
import org.junit.jupiter.api.Test

class ResetPasswordTest {
       //T11 - UC8 - SDA11 Basic Scenario
    @Test
    fun resetPasswordBasicFlowTest() {
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
        val loginComponent = LoginComponent(userRepository)
        loginComponent.reduce(
            LoginEvent.PasswordForgotClickLoginEvent("example@example.com", "Qqwerty1!New")
        )
    }
    //T11.2 - UC8 - SDA11 Alternate Scenario
    @Test
    fun resetPasswordAlternativeFlow() {
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
        val loginComponent = LoginComponent(userRepository)
        loginComponent.reduce(LoginEvent.PasswordForgotClickLoginEvent("exampleNotExists@example.com", "Qqwerty1!New"))
    }
}