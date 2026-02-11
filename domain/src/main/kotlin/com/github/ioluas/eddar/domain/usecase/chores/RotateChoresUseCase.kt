package com.github.ioluas.eddar.domain.usecase.chores

import com.github.ioluas.eddar.domain.model.Chore
import com.github.ioluas.eddar.domain.model.Team
import com.github.ioluas.eddar.domain.repository.ChoreRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Logic for rotating chores among team members.
 * This is a basic implementation that moves to the next member in the list.
 */
class RotateChoresUseCase @Inject constructor(
    private val choreRepository: ChoreRepository
) {
    suspend operator fun invoke(team: Team) {
        if (team.memberIds.isEmpty()) return

        val chores = choreRepository.getTeamChores(team.id).first()
        
        chores.forEach { chore ->
            val currentIndex = team.memberIds.indexOf(chore.assignedUserId)
            val nextIndex = (currentIndex + 1) % team.memberIds.size
            val nextUserId = team.memberIds[nextIndex]
            
            val rotatedChore = chore.copy(assignedUserId = nextUserId)
            choreRepository.saveChore(rotatedChore)
        }
    }
}
