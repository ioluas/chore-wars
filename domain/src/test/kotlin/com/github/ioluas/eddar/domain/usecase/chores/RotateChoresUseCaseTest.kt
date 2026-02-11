package com.github.ioluas.eddar.domain.usecase.chores

import com.github.ioluas.eddar.domain.model.Chore
import com.github.ioluas.eddar.domain.model.ChoreFrequency
import com.github.ioluas.eddar.domain.model.TaskCompletion
import com.github.ioluas.eddar.domain.model.Team
import com.github.ioluas.eddar.domain.repository.ChoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class RotateChoresUseCaseTest {

    private val mockRepository = object : ChoreRepository {
        var savedChores = mutableListOf<Chore>()
        
        override fun getTeamChores(teamId: String): Flow<List<Chore>> = flowOf(
            listOf(
                Chore("1", "team1", "Chore 1", "", ChoreFrequency.WEEKLY, 1, "user1")
            )
        )
        override fun getChore(choreId: String): Flow<Chore?> = flowOf(null)
        override suspend fun saveChore(chore: Chore) { savedChores.add(chore) }
        override suspend fun deleteChore(choreId: String) {}
        override suspend fun completeChore(completion: TaskCompletion) {}
        override fun getTeamCompletionHistory(teamId: String, limit: Int): Flow<List<TaskCompletion>> = flowOf(emptyList())
    }

    @Test
    fun `rotate chores moves assignment to next member`() = runTest {
        val useCase = RotateChoresUseCase(mockRepository)
        val team = Team("team1", "Home", "CODE", "user1", listOf("user1", "user2"))
        
        useCase(team)
        
        assertEquals(1, mockRepository.savedChores.size)
        assertEquals("user2", mockRepository.savedChores[0].assignedUserId)
    }
}
