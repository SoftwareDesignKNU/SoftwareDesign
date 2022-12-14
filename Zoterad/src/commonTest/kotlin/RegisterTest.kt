import auth.data.UserRepository
import auth.domain.IUserRepository
import auth.presentation.RegisterComponent
import auth.presentation.RegisterEvent
import auth.presentation.RegisterState
import kotlin.test.Test

class RegisterTest {
    @Test
    fun registerTestBasicFLow() {
        val userRepository: IUserRepository = UserRepository()
        val component = RegisterComponent(userRepository)
        component.registerState = RegisterState(
            username = "example",
            email = "example@example.com",
            emailConfirm = "example@example.com",
            password = "Qqwerty1!",
            verifyPassword = "Qqwerty1!"
        )
        component.reduce(RegisterEvent.RegistrationClickRegisterEvent)
    }
}