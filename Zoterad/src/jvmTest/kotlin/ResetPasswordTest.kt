import auth.data.UserRepository
import auth.presentation.*
import org.junit.jupiter.api.Test

class ResetPasswordTest {
    @Test
    fun resetPasswordBasicFlowTest() {
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
        val loginComponent = LoginComponent(userRepository)
        loginComponent.reduce(
            LoginEvent.PasswordForgotClickLoginEvent("example@example.com", "Qqwerty1!New")
        )
    }

    @Test
    fun resetPasswordAlternativeFlow() {
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
        val loginComponent = LoginComponent(userRepository)
        loginComponent.reduce(LoginEvent.PasswordForgotClickLoginEvent("exampleNotExists@example.com", "Qqwerty1!New"))
    }
}