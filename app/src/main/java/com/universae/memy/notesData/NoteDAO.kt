package com.universae.memy.notesData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface NoteDAO {
    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)
    @Delete
    fun delete(note: Note)

    @Query("SELECT * FROM notes_table WHERE noteId = :noteId")
    fun get(noteId: Long) : LiveData<Note>

    @Query("SELECT * FROM notes_table ORDER BY noteId DESC")
    fun getAll(): LiveData<List<Note>>
}