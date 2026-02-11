package com.github.ioluas.eddar.domain.model

/**
 * Represents a user in the Eddar ecosystem.
 *
 * @property id Unique identifier for the user (typically from Firebase Auth).
 * @property name Display name of the user.
 * @property email Primary contact email.
 * @property profileImageUrl Optional URL to the user's profile picture.
 */
data class User(
    val id: String,
    val name: String,
    val email: String,
    val profileImageUrl: String? = null
)
