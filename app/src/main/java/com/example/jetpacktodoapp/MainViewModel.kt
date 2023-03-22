package com.example.jetpacktodoapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val taskDAO: TaskDAO) : ViewModel() {
    var title by mutableStateOf("")
    var description by mutableStateOf("")
}