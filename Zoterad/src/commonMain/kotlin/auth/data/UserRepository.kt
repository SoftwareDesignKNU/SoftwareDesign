package auth.data

import auth.data.client.HttpClient
import auth.data.database.Database
import auth.domain.IUserRepository
import common.data.secure_storage.SecureDataStore
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val database: Database,
    private val client: HttpClient,
    private val secureDataStore: SecureDataStore,
) : IUserRepository {
    override suspend fun login(loginRequestData: LoginDTO): Result<String> {
        TODO(
            "send request through HttpClient\n" +
                    "get JWT response\n" +
                    "safe JWT to secure data store\n" +
                    "return successful result with JWT"
        )
    }

    override suspend fun register(registerRequestData: RegisterDTO): Result<String> {
        TODO("send request through HTTP Client")
    }

    override suspend fun getUserByEmail(email: String): Result<User> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserByUsername(username: String): Result<User> {
        TODO("Not yet implemented")
    }

    override fun getUsers(): Result<Flow<User>> {
        TODO("Not yet implemented")
    }

    override suspend fun sendPasswordChangeRequest(email: String): Result<Nothing> {
        TODO("Not yet implemented")
    }

    override suspend fun sendPasswordConfirmation(otp: String): Result<Nothing> {
        TODO("Not yet implemented")
    }
}