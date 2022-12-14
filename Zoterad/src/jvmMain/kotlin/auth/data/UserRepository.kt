package auth.data

import data.client.HttpClient
import data.database.Database
import auth.data.entity.LoginDTO
import auth.data.entity.RegisterDTO
import auth.data.entity.User
import auth.domain.IUserRepository

class UserRepository(
    private val database: Database,
    private val client: HttpClient,
) : IUserRepository {
    override suspend fun login(loginRequestData: LoginDTO): Result<String> {
        println("UserRepository: login($loginRequestData)")
        return try {
            client.login(loginRequestData)?.let { Result.success(it) }.also {
                val user = client.getUser(loginRequestData.emailOrUsername)
                database.user = user
            } ?: Result.failure(Exception("Auth error"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun register(registerRequestData: RegisterDTO): Result<String> {
        println("UserRepository: register($registerRequestData)")
        return try {
            client.register(registerRequestData)?.let { Result.success(it) }
                ?: Result.failure(Exception("Register error"))
        } catch (e: Exception) {
            Result.failure(e)
        }
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
        println("UserRepository: sendPasswordChangeRequest($email)")
        return try {
            val otp = client.sendPasswordChangeRequest(email)
            Result.success(otp)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun sendPasswordConfirmation(otp: String): Result<Unit> {
        println("UserRepository: sendPasswordConfirmation($otp)")
        return try {
            client.sendPasswordConfirmation(otp)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun changePassword(email: String, newPassword: String): Result<String> {
        println("UserRepository: changePassword($email, $newPassword)")
        return try {
            Result.success(client.changePassword(email, newPassword))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}