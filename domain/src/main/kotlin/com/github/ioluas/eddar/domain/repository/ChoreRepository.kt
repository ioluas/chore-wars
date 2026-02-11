package com.github.ioluas.eddar.domain.repository

import com.github.ioluas.eddar.domain.model.Chore
import com.github.ioluas.eddar.domain.model.TaskCompletion
import kotlinx.coroutines.flow.Flow

/**
 * Interface for chore management and tracking.
 */
interface ChoreRepository {
    /**
     * Retrieves all chores for a specific team.
     */
    fun getTeamChores(teamId: String): Flow<List<Chore>>

    /**
     * Retrieves a specific chore by ID.
     */
    fun getChore(choreId: String): Flow<Chore?>

    /**
     * Creates or updates a chore definition.
     */
    suspend fun saveChore(chore: Chore)

    /**
     * Deletes a chore.
     */
    suspend fun deleteChore(choreId: String)

    /**
     * Records a chore completion and updates the chore's lastCompletedAt.
     */
    suspend fun completeChore(completion: TaskCompletion)

    /**
     * Retrieves completion history for a team.
     */
    fun getTeamCompletionHistory(teamId: String, limit: Int = 50): Flow<List<TaskCompletion>>
}
