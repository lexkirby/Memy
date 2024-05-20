package com.universae.memy.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.universae.memy.taskData.TaskDAO
import com.universae.memy.viewModel.TaskVM

class TaskVMF(private val daoTask: TaskDAO): ViewModelProvider.Factory{

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskVM::class.java)) {
            return TaskVM(daoTask) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}