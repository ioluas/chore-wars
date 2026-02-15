package com.github.ioluas.eddar.domain.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class ChoreTest {

    @Test
    fun `chore creation with valid data succeeds`() {
        val chore = Chore(
            id = "1",
            teamId = "team_1",
            name = "Vacuum",
            description = "Vacuum the living room",
            frequency = ChoreFrequency.WEEKLY,
            difficultyScore = 5
        )
        
        assertEquals("Vacuum", chore.name)
        assertEquals(5, chore.difficultyScore)
    }

    @Test
    fun `chore creation with invalid difficulty score throws exception`() {
        // Test upper bound
        assertThrows(IllegalArgumentException::class.java) {
            Chore(
                id = "1",
                teamId = "team_1",
                name = "Vacuum",
                description = "Vacuum",
                frequency = ChoreFrequency.WEEKLY,
                difficultyScore = 11
            )
        }
        // Test lower bound
        assertThrows(IllegalArgumentException::class.java) {
            Chore(
                id = "1",
                teamId = "team_1",
                name = "Vacuum",
                description = "Vacuum",
                frequency = ChoreFrequency.WEEKLY,
                difficultyScore = 0
            )
        }
    }

    @Test
    fun `chore creation with boundary difficulty scores succeeds`() {
        // Test lower valid bound
        val choreMin = Chore(
            id = "1",
            teamId = "team_1",
            name = "Vacuum",
            description = "Vacuum",
            frequency = ChoreFrequency.WEEKLY,
            difficultyScore = 1
        )
        assertEquals(1, choreMin.difficultyScore)

        // Test upper valid bound
        val choreMax = Chore(
            id = "2",
            teamId = "team_1",
            name = "Vacuum",
            description = "Vacuum",
            frequency = ChoreFrequency.WEEKLY,
            difficultyScore = 10
        )
        assertEquals(10, choreMax.difficultyScore)
    }

    @Test
    fun `chore creation with empty name throws exception`() {
        assertThrows(IllegalArgumentException::class.java) {
            Chore(
                id = "1",
                teamId = "team_1",
                name = "",
                description = "Vacuum",
                frequency = ChoreFrequency.WEEKLY
            )
        }
    }
}
