package xyz.teamgravity.navigation3screentransition

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route : NavKey {

    @Serializable
    data object TodoList : Route

    @Serializable
    data class Todo(val todoExtra: String) : Route
}