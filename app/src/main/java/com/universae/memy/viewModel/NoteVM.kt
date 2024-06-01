package com.universae.memy.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universae.memy.notesData.Note
import com.universae.memy.notesData.NoteDAO
import kotlinx.coroutines.launch

/*Creamos una clase NoteVM que se extienda de la clase ViewModel y le pasamos un objeto DAO NoteDAO*/
class NoteVM (val daoNote: NoteDAO) : ViewModel(){
    /*Declaramos las variables que contendrán la información de las columnas de la tabla Note*/
    var newNoteName = ""
    var newNoteContent = ""
    val notes = daoNote.getAll()

    /*Creamos un método para añadir notas. Este creará un objeto Note y usará el método insert
     de NoteDAO para añadir los datos a la base de datos */
    fun addNote() {
        /*viewModelScope lanzará la coroutine del método insert dentro del alcance del ViewModel
        cada vez que se llame el método */
        viewModelScope.launch {
            val noteN = Note()
            noteN.noteName = newNoteName
            noteN.noteContent = newNoteContent
            daoNote.insert(noteN)
        }
    }

}