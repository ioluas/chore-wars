package com.github.ioluas.eddar.domain.repository

import com.github.ioluas.eddar.domain.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Interface for authentication-related operations.
 */
interface AuthRepository {
    /**
     * Returns a Flow of the currently authenticated user's ID.
     * Emits null if no user is signed in.
     */
    val currentUserId: Flow<String?>

    /**
     * Signs out the current user.
     */
    suspend fun signOut()

    /**
     * Returns true if a user is currently signed in.
     */
    fun isUserSignedIn(): Boolean
}
