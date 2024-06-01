package com.universae.memy.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universae.memy.taskData.Task
import com.universae.memy.taskData.TaskDAO
import kotlinx.coroutines.launch

/*Creamos una clase TaskVM que se extienda de la clase ViewModel y le pasamos un objeto DAO TaskDAO*/
class TaskVM(val daoTask: TaskDAO): ViewModel() {
    /*Declaramos las variables que contendrán la información de las columnas de la tabla Task*/
    var newTaskName = ""
    val tasks = daoTask.getAll()

    /*Creamos un método para añadir tareas. Este creará un objeto Task y usará el método insert
     de TaskDAO para añadir los datos a la base de datos */
    fun addTask() {
        /*viewModelScope lanzará la coroutine del método insert dentro del alcance del ViewModel
        cada vez que se llame el método */
        viewModelScope.launch {
            val task = Task()
            task.taskName = newTaskName
            daoTask.insert(task)
        }
    }

}