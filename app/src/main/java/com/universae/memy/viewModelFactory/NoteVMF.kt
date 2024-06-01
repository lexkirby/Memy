package com.universae.memy.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.universae.memy.notesData.NoteDAO
import com.universae.memy.viewModel.NoteVM

/*Creamos la clase NoteVMF que implementa la interfaz ViewModelProvider.Factory que crea ViewModels y
le pasamos un objeto DAO NoteDAO como parámetro */
class NoteVMF(private val daoNote: NoteDAO): ViewModelProvider.Factory {

    /*Sobreescribimos el método para crear ViewModels usando un objeto NoteDao para crear un objeto
     NoteVMF. T tiene que ser una subclase de ViewModel y crea un ViewModel del tipo de clase que
     sea modelClass, si modelClass es una clase NoteVM o subclase de esta devuelve una instancia
     del ViewModel con el parámetro NoteDAO como T*/
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteVM::class.java)) {
            return NoteVM(daoNote) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}