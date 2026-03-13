package xyz.teamgravity.navigation3screentransition

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoViewModel(
    todoExtra: String
) : ViewModel() {

    private val _todo = MutableStateFlow(todoExtra)
    val todo: StateFlow<String> = _todo.asStateFlow()
}