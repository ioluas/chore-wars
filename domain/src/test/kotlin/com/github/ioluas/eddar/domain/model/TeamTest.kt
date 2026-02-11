package com.github.ioluas.eddar.domain.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class TeamTest {

    @Test
    fun `team creation with members succeeds`() {
        val members = listOf("user_1", "user_2")
        val team = Team(
            id = "team_1",
            name = "Home",
            inviteCode = "ABCD12",
            ownerId = "user_1",
            memberIds = members
        )
        
        assertEquals(2, team.memberIds.size)
        assertTrue(team.memberIds.contains("user_1"))
    }

    @Test
    fun `adding member creates new team instance with updated list`() {
        val team = Team("1", "Home", "CODE", "owner")
        val updatedTeam = team.copy(memberIds = team.memberIds + "new_user")
        
        assertEquals(0, team.memberIds.size)
        assertEquals(1, updatedTeam.memberIds.size)
        assertEquals("new_user", updatedTeam.memberIds.first())
    }
}
