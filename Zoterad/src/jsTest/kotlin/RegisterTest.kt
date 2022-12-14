import auth.data.UserRepository
import auth.domain.IUserRepository
import auth.register.presentation.RegisterComponent
import auth.register.presentation.RegisterEvent
import auth.register.presentation.RegisterState
import kotlin.test.Test
import kotlin.test.assertTrue

class RegisterTest {
    @Test
    fun registerTestBasicFLow() {
        val userRepository: IUserRepository = UserRepository()
        val component = RegisterComponent(userRepository)
        component.registerState = RegisterState(
            username = "example",
            email = "example@example.com"
        )
        component.reduce(RegisterEvent.RegistrationClickRegisterEvent)
        assertTrue {
            // check should be done here
            true
        }
    }
}