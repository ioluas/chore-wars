package com.github.ioluas.eddar.domain.model

import java.util.Date

/**
 * Represents a specific task that needs to be performed within a team.
 *
 * @property id Unique identifier for the chore.
 * @property teamId The ID of the team this chore belongs to.
 * @property name Name of the chore (e.g., "Take out the trash").
 * @property description Detailed instructions for the chore.
 * @property frequency How often the chore repeats.
 * @property difficultyScore Points assigned to this chore for fair distribution.
 * @property assignedUserId The ID of the user currently responsible for this chore.
 * @property lastCompletedAt Timestamp of the most recent completion.
 * @property createdAt Timestamp when the chore was created.
 */
data class Chore(
    val id: String,
    val teamId: String,
    val name: String,
    val description: String,
    val frequency: ChoreFrequency,
    val difficultyScore: Int = 1,
    val assignedUserId: String? = null,
    val lastCompletedAt: Date? = null,
    val createdAt: Date = Date()
) {
    init {
        require(difficultyScore in 1..10) { "Difficulty score must be between 1 and 10" }
        require(name.isNotBlank()) { "Chore name cannot be empty" }
    }
}
