package com.universae.memy.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.universae.memy.taskData.Task
import com.universae.memy.taskData.TaskDAO
import kotlinx.coroutines.launch


class TaskVM(val daoTask: TaskDAO): ViewModel() {
    var newTaskName = ""
    private val tasks = daoTask.getAll()
    val tasksString = tasks.map { tasks -> formatTasks(tasks) }
    fun addTask() {
        viewModelScope.launch {
            val task = Task()
            task.taskName = newTaskName
            daoTask.insert(task)
        }
    }
    fun formatTasks(tasks: List<Task>): String {
        return tasks.fold("") {
            str, item -> str + '\n' + formatTask(item)
        }
    }

    fun formatTask(task: Task): String {
        var str = "ID: ${task.taskId}"
        str += '\n' + "Name: ${task.taskName}"
        str += '\n' + "Complete: ${task.taskDone}" + '\n'
        return str
    }
}