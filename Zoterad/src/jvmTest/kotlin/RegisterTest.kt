import auth.data.UserRepository
import auth.domain.IUserRepository
import auth.presentation.RegisterComponent
import auth.presentation.RegisterEvent
import auth.presentation.RegisterState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class RegisterTest {
    @Test
    fun registerTestBasicFLow() = runBlocking {
        val job = CoroutineScope(Dispatchers.IO).launch {
            val userRepository: IUserRepository = UserRepository()
            val component = RegisterComponent(userRepository)
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
        }
        job.join()
    }
}