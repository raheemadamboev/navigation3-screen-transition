package xyz.teamgravity.navigation3screentransition

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TodoListScreen(
    onNavigateTodo: (todo: String) -> Unit,
    viewmodel: TodoListViewModel = viewModel { TodoListViewModel() }
) {
    val todos by viewmodel.todos.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            items(todos) { todo ->
                Text(
                    text = todo,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onNavigateTodo(todo)
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}