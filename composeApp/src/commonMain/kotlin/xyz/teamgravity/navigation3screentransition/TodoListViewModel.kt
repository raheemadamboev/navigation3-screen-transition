package xyz.teamgravity.navigation3screentransition

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoListViewModel : ViewModel() {

    private val _todos = MutableStateFlow(List(100) { "Todo $it" })
    val todos: StateFlow<List<String>> = _todos.asStateFlow()
}