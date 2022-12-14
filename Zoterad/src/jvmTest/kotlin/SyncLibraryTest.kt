import auth.data.UserRepository
import auth.presentation.*
import collection.data.LocalCollectionRepository
import data.client.HttpClient
import data.database.Database
import item.data.LocalItemRepository
import main.main.MainComponent
import main.main.MainEvent
import org.junit.jupiter.api.Test
import sync.data.SyncRepository

class SyncLibraryTest {
    //T12 - UC12 - SDA12 
    @Test
    fun syncLibraryBasicFlowTest() {
        val database = Database()
        val client = HttpClient()
        val userRepository = UserRepository(database, client)
        val registerComponent = RegisterComponent(userRepository)
        val loginComponent = LoginComponent(userRepository)
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
        loginComponent.loginState = LoginState(username = "example", password = "Qqwerty1!")
        loginComponent.reduce(LoginEvent.LoginButtonClickLoginEven)
        val mainComponent = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        mainComponent.reduce(MainEvent.SyncLibraryMainEvent)
    }
    //T12.2 - UC12 - SDA12 Alternate Flow
    @Test
    fun syncLibraryAlternativeFlowTest() {
        val database = Database()
        val client = HttpClient()
        val userRepository = UserRepository(database, client)
        val registerComponent = RegisterComponent(userRepository)
        val loginComponent = LoginComponent(userRepository)
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
        loginComponent.loginState = LoginState(username = "example", password = "Qqwerty!")
        loginComponent.reduce(LoginEvent.LoginButtonClickLoginEven)
        val mainComponent = MainComponent(
            collectionRepository = LocalCollectionRepository(database),
            itemRepository = LocalItemRepository(0, database),
            syncRepository = SyncRepository(database, client)
        )
        mainComponent.reduce(MainEvent.SyncLibraryMainEvent)
    }
}