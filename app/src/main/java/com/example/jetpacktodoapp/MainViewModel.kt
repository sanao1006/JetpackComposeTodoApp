package com.example.jetpacktodoapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val taskDAO: TaskDAO) : ViewModel() {
    var title by mutableStateOf("")
    var description by mutableStateOf("")
    var isShowDialog by mutableStateOf(false)

    val tasks = taskDAO.loadAllTask().distinctUntilChanged()

    fun createTask() {
        viewModelScope.launch {
            var newTask = Task(title = title, description = description)
            taskDAO.insertTask(newTask)

        }
    }
}