package com.example.jetpacktodoapp

import androidx.room.*

@Dao
interface TaskDAO {
    @Insert
    fun insertTask(task: Task)

    @Query("SELECT * FROM Task")
    fun loadAllTask(): List<Task>

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}