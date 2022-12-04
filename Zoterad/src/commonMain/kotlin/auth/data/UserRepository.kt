package auth.data

import common.data.client.HttpClient
import common.data.database.Database
import auth.data.entity.LoginDTO
import auth.data.entity.RegisterDTO
import auth.data.entity.User
import auth.domain.IUserRepository

class UserRepository(
    private val database: Database,
    private val client: HttpClient,
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

    override suspend fun getUsers(): Result<List<User>> {
        TODO("Not yet implemented")
    }

    override suspend fun sendPasswordChangeRequest(email: String): Result<Nothing> {
        TODO("Not yet implemented")
    }

    override suspend fun sendPasswordConfirmation(otp: String): Result<Nothing> {
        TODO("Not yet implemented")
    }
}