package com.github.ioluas.eddar.domain.repository

import com.github.ioluas.eddar.domain.model.Team
import kotlinx.coroutines.flow.Flow

/**
 * Interface for team and household management.
 */
interface TeamRepository {
    /**
     * Retrieves a team by its ID.
     */
    fun getTeam(teamId: String): Flow<Team?>

    /**
     * Retrieves all teams the user is a member of.
     */
    fun getUserTeams(userId: String): Flow<List<Team>>

    /**
     * Creates a new team.
     */
    suspend fun createTeam(team: Team): Result<Unit>

    /**
     * Joins a team using an invite code.
     */
    suspend fun joinTeam(userId: String, inviteCode: String): Result<Unit>

    /**
     * Leaves a team.
     */
    suspend fun leaveTeam(userId: String, teamId: String): Result<Unit>
}
