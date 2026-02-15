package com.github.ioluas.eddar.domain.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class TaskCompletionTest {

    @Test
    fun `task completion creation with valid data succeeds`() {
        val completion = TaskCompletion(
            id = "1",
            choreId = "chore_1",
            userId = "user_1",
            userName = "John Doe",
            choreName = "Vacuum",
            difficultyScore = 5
        )
        
        assertEquals(5, completion.difficultyScore)
    }

    @Test
    fun `task completion creation with invalid difficulty score throws exception`() {
        // Test upper bound
        assertThrows(IllegalArgumentException::class.java) {
            TaskCompletion(
                id = "1",
                choreId = "chore_1",
                userId = "user_1",
                userName = "John Doe",
                choreName = "Vacuum",
                difficultyScore = 11
            )
        }
        // Test lower bound
        assertThrows(IllegalArgumentException::class.java) {
            TaskCompletion(
                id = "1",
                choreId = "chore_1",
                userId = "user_1",
                userName = "John Doe",
                choreName = "Vacuum",
                difficultyScore = 0
            )
        }
    }

    @Test
    fun `task completion creation with boundary difficulty scores succeeds`() {
        // Test lower valid bound
        val completionMin = TaskCompletion(
            id = "1",
            choreId = "chore_1",
            userId = "user_1",
            userName = "John Doe",
            choreName = "Vacuum",
            difficultyScore = 1
        )
        assertEquals(1, completionMin.difficultyScore)

        // Test upper valid bound
        val completionMax = TaskCompletion(
            id = "2",
            choreId = "chore_1",
            userId = "user_1",
            userName = "John Doe",
            choreName = "Vacuum",
            difficultyScore = 10
        )
        assertEquals(10, completionMax.difficultyScore)
    }
}
