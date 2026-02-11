package com.github.ioluas.eddar.domain.model

/**
 * Represents a household or a group of users who share chores.
 *
 * @property id Unique identifier for the team.
 * @property name Human-readable name of the household (e.g., "The Baker Residence").
 * @property inviteCode A unique code used by others to join this team.
 * @property ownerId The ID of the user who created the team.
 */
data class Team(
    val id: String,
    val name: String,
    val inviteCode: String,
    val ownerId: String,
    val memberIds: List<String> = emptyList()
)
