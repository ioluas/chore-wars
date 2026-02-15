package com.github.ioluas.eddar.domain.model

import java.util.Date

/**
 * Represents a single instance of a completed chore.
 * Used for history tracking and fairness calculations.
 *
 * @property id Unique identifier for the completion record.
 * @property choreId ID of the chore that was completed.
 * @property userId ID of the user who completed the chore.
 * @property userName Name of the user at the time of completion (denormalized for history).
 * @property choreName Name of the chore at the time of completion.
 * @property completedAt Timestamp of completion.
 * @property difficultyScore Difficulty score of the chore at the time of completion.
 * @property notes Optional notes or comments regarding the task.
 */
data class TaskCompletion(
    val id: String,
    val choreId: String,
    val userId: String,
    val userName: String,
    val choreName: String,
    val completedAt: Date = Date(),
    val difficultyScore: Int,
    val notes: String? = null
) {
    init {
        require(difficultyScore in 1..10) { "Difficulty score must be between 1 and 10" }
    }
}
