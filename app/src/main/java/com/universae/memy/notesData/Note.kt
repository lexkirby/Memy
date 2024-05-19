package com.universae.memy.notesData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var noteId: Long = 0L,
    @ColumnInfo(name = "note_name")
    var noteName: String? = null,
    @ColumnInfo(name = "note_content")
    var noteContent: String = ""
)
