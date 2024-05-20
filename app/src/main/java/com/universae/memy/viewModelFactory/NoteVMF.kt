package com.universae.memy.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.universae.memy.notesData.NoteDAO
import com.universae.memy.viewModel.NoteVM


class NoteVMF(private val daoNote: NoteDAO): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteVM::class.java)) {
            return NoteVM(daoNote) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}