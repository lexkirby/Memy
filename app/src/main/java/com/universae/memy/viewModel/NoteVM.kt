package com.universae.memy.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universae.memy.notesData.Note
import com.universae.memy.notesData.NoteDAO
import kotlinx.coroutines.launch

class NoteVM (val daoNote: NoteDAO) : ViewModel(){
    var newNoteName = ""
    var newNoteContent = ""
    val notes = daoNote.getAll()

    fun addNote() {
        viewModelScope.launch {
            val noteN = Note()
            noteN.noteName = newNoteName
            noteN.noteContent = newNoteContent
            daoNote.insert(noteN)
        }
    }

}