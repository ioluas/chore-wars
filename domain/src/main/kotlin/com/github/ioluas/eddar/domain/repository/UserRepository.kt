package com.github.ioluas.eddar.domain.repository

import com.github.ioluas.eddar.domain.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Interface for user profile data operations.
 */
interface UserRepository {
    /**
     * Retrieves a user by their ID.
     */
    fun getUser(userId: String): Flow<User?>

    /**
     * Updates or creates a user profile.
     */
    suspend fun saveUser(user: User)
}
