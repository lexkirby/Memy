package com.universae.memy.notesData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*Marcamos la clase como tabla con la anotación @Entity*/
@Entity(tableName = "notes_table")
data class Note(
    /* Marcamos la variable noteId como PrimaryKey autogenerada */
    @PrimaryKey(autoGenerate = true)
    var noteId: Long = 0L,

    /* Con la anotación @ColumnInfo le indicamos qué nombre tendrá la columna y
     debajo indica que la columna contendrá elementos de tipo String para el título de la nota
     que pueden ser null  */

    @ColumnInfo(name = "note_name")
    var noteName: String? = null,

    /* Con la anotación @ColumnInfo le indicamos qué nombre tendrá la columna y
   debajo indica que la columna contendrá elementos de tipo String para el contenido de la nota */

    @ColumnInfo(name = "note_content")
    var noteContent: String = ""
)
