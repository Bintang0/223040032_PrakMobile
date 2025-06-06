package id.ac.unpas.storyapp2.data.repository

import id.ac.unpas.storyapp2.data.local.dao.UserDao
import id.ac.unpas.storyapp2.data.remote.ApiService
import id.ac.unpas.storyapp2.data.helper.Result
import id.ac.unpas.storyapp2.data.local.entity.UserEntity
import id.ac.unpas.storyapp2.data.remote.model.LoginRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao
) {
    suspend fun login(email: String, password: String): Flow<Result<UserEntity>> = flow {
        emit(Result.Loading)
        try {
            val response = apiService.login(LoginRequest(email, password))
            if (response.error) {
                emit(Result.Error(response.message))
            } else {
                val user = UserEntity(
                    userId = response.loginResult.userId,
                    name = response.loginResult.name,
                    token = response.loginResult.token
                )
                userDao.insertUser(user)
                emit(Result.Success(user))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message ?: "Terjadi kesalahan"))
        }
    }
}