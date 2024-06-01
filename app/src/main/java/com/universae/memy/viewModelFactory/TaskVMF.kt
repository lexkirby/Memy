package com.universae.memy.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.universae.memy.taskData.TaskDAO
import com.universae.memy.viewModel.TaskVM

/*Creamos la clase TaskVMF que implementa la interfaz ViewModelProvider.Factory que crea ViewModels y
le pasamos un objeto DAO TaskDAO como parámetro */
class TaskVMF(private val daoTask: TaskDAO): ViewModelProvider.Factory{

    /*Sobreescribimos el método para crear ViewModels usando un objeto TaskDao para crear un objeto
    TaskVMF. T tiene que ser una subclase de ViewModel y crea un ViewModel del tipo de clase que
    sea modelClass, si modelClass es una clase TaskVM o subclase de esta devuelve una instancia
    del ViewModel con el parámetro TaskDAO como T*/
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskVM::class.java)) {
            return TaskVM(daoTask) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}