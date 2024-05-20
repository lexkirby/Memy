package com.universae.memy.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.universae.memy.notesData.Note
import com.universae.memy.notesData.NoteDAO
import kotlinx.coroutines.launch

class NoteVM (val daoNote: NoteDAO) : ViewModel(){
    var newNoteName = ""
    var newNoteContent = ""
    val notes = daoNote.getAll()
    val notesString = notes.map { notes -> formatNotes(notes) }
    fun addNote() {
        viewModelScope.launch {
            val noteN = Note()
            noteN.noteName = newNoteName
            noteN.noteContent = newNoteContent
            daoNote.insert(noteN)
        }
    }
    fun formatNotes(notes: List<Note>): String {
        return notes.fold("") {
                str, item -> str + '\n' + formatNote(item)
        }
    }

    fun formatNote(note: Note): String {
        var str = "${note.noteName}"
        str += '\n' + ": ${note.noteContent}" + '\n'
        return str
    }
}