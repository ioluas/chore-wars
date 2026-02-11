package com.github.ioluas.eddar.domain.usecase.chores

import com.github.ioluas.eddar.domain.model.Chore
import com.github.ioluas.eddar.domain.model.TaskCompletion
import com.github.ioluas.eddar.domain.model.User
import com.github.ioluas.eddar.domain.repository.ChoreRepository
import java.util.UUID
import javax.inject.Inject

/**
 * Handles the logic for completing a chore.
 */
class CompleteChoreUseCase @Inject constructor(
    private val choreRepository: ChoreRepository
) {
    suspend operator fun invoke(chore: Chore, user: User, notes: String? = null) {
        val completion = TaskCompletion(
            id = UUID.randomUUID().toString(),
            choreId = chore.id,
            userId = user.id,
            userName = user.name,
            choreName = chore.name,
            difficultyScore = chore.difficultyScore,
            notes = notes
        )
        
        choreRepository.completeChore(completion)
    }
}
