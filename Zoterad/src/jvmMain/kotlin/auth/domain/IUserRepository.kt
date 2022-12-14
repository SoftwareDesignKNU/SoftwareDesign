package auth.domain

import auth.data.entity.LoginDTO
import auth.data.entity.RegisterDTO
import auth.data.entity.User

interface IUserRepository {
    suspend fun login(
        loginRequestData: LoginDTO): Result<String>
    suspend fun register(registerRequestData: RegisterDTO): Result<String>
    suspend fun getUserByEmail(email: String): Result<User>
    suspend fun getUserByUsername(username: String): Result<User>
    suspend fun getUsers(): Result<List<User>>
    suspend fun sendPasswordChangeRequest(email: String): Result<String>
    suspend fun sendPasswordConfirmation(otp: String): Result<Unit>
    suspend fun changePassword(email: String, newPassword: String): Result<String>
}