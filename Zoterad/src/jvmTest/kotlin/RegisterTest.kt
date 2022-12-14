import auth.data.UserRepository
import auth.presentation.RegisterComponent
import auth.presentation.RegisterEvent
import auth.presentation.RegisterState
import kotlin.test.Test

class RegisterTest {
    @Test
    fun registerTestBasicFLow() {
        val registerComponent = RegisterComponent(UserRepository())
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
    }

    @Test
    fun registerFirstAlternativeFlow() {
        val component = RegisterComponent(UserRepository())
        component.registerState = RegisterState(
            username = "example",
            email = "example@example.com",
            emailConfirm = "example@example.com",
            password = "Qqwerty1!",
            verifyPassword = "Qqwerty1!",
            firstName = "FirstName",
            lastName = "LastName"
        )
        component.reduce(RegisterEvent.RegistrationClickRegisterEvent)
        component.registerState = RegisterState(
            username = "example1",
            email = "example@example.com",
            emailConfirm = "example@example.com",
            password = "Qqwerty1!",
            verifyPassword = "Qqwerty1!",
            firstName = "FirstName",
            lastName = "LastName"
        )
        component.reduce(RegisterEvent.RegistrationClickRegisterEvent)
    }

    @Test
    fun registerSecondAlternativeFlow() {
        val component = RegisterComponent(UserRepository())
        component.registerState = RegisterState(
            username = "example",
            email = "example@example.com",
            emailConfirm = "example@example.com",
            password = "Qqwerty1!",
            verifyPassword = "Qqwerty1!",
            firstName = "FirstName",
            lastName = "LastName"
        )
        component.reduce(RegisterEvent.RegistrationClickRegisterEvent)
        component.registerState = RegisterState(
            username = "example",
            email = "example1@example.com",
            emailConfirm = "example1@example.com",
            password = "Qqwerty1!",
            verifyPassword = "Qqwerty1!",
            firstName = "FirstName",
            lastName = "LastName"
        )
        component.reduce(RegisterEvent.RegistrationClickRegisterEvent)
    }
}