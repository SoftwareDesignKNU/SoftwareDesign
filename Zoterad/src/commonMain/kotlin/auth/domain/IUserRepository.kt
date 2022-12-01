package auth.domain

import auth.data.LoginDTO
import auth.data.RegisterDTO
import auth.data.User
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    suspend fun login(loginRequestData: LoginDTO): Result<String>
    suspend fun register(registerRequestData: RegisterDTO): Result<String>
    suspend fun getUserByEmail(email: String): Result<User>
    suspend fun getUserByUsername(username: String): Result<User>
    fun getUsers(): Result<Flow<User>>
    suspend fun sendPasswordChangeRequest(email: String): Result<Nothing>
    suspend fun sendPasswordConfirmation(otp: String): Result<Nothing>
}