package com.universae.memy.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universae.memy.taskData.Task
import com.universae.memy.taskData.TaskDAO
import kotlinx.coroutines.launch


class TaskVM(val daoTask: TaskDAO): ViewModel() {
    var newTaskName = ""
    val tasks = daoTask.getAll()

    fun addTask() {
        viewModelScope.launch {
            val task = Task()
            task.taskName = newTaskName
            daoTask.insert(task)
        }
    }

}