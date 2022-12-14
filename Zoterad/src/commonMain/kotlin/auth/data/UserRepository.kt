package auth.data

import common.data.client.HttpClient
import common.data.database.Database
import auth.data.entity.LoginDTO
import auth.data.entity.RegisterDTO
import auth.data.entity.User
import auth.domain.IUserRepository

class UserRepository(
    private val database: Database = Database(),
    private val client: HttpClient = HttpClient(),
) : IUserRepository {
    override suspend fun login(loginRequestData: LoginDTO): Result<String> {
        return client.login(loginRequestData)?.let { Result.success(it) } ?: Result.failure(Exception("Auth error"))
    }

    override suspend fun register(registerRequestData: RegisterDTO): Result<String> {
        return client.register(registerRequestData)?.let { Result.success(it) }
            ?: Result.failure(Exception("Register error"))
    }

    override suspend fun getUserByEmail(email: String): Result<User> {
        return database.getUserByEmail(email)?.let { Result.success(it) } ?: Result.failure(Exception("User not found"))
    }

    override suspend fun getUserByUsername(username: String): Result<User> {
        return database.getUserByUsername(username)?.let { Result.success(it) }
            ?: Result.failure(Exception("User not found"))
    }

    override suspend fun getUsers(): Result<List<User>> {
        return Result.success(database.getUsers())
    }

    override suspend fun sendPasswordChangeRequest(email: String): Result<String> {
        return try {
            val otp = client.sendPasswordChangeRequest(email)
            Result.success(otp)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun sendPasswordConfirmation(otp: String): Result<Unit> {
        return try {
            client.sendPasswordConfirmation(otp)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun changePassword(email: String, newPassword: String): Result<String> {
        return try {
            Result.success(client.changePassword(email, newPassword))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}