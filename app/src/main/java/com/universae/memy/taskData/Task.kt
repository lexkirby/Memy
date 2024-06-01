package com.universae.memy.taskData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*Marcamos la clase como tabla con la anotación @Entity*/
@Entity(tableName = "task_table")
data class Task (
    /* Marcamos la variable taskId como PrimaryKey autogenerada */
    @PrimaryKey(autoGenerate = true)
    var taskId: Long = 0L,

    /* Con la anotación @ColumnInfo le indicamos qué nombre tendrá la columna y
   debajo indicamos que la columna contendrá un elementos de tipo String para el nombre de la tarea */

    @ColumnInfo(name = "task_name")
    var taskName: String = "",

    /* Con la anotación @ColumnInfo le indicamos qué nombre tendrá la columna y
 debajo indicamos que la columna contendrá elementos de tipo Boolean para marcar si está completada
  la tarea */

    @ColumnInfo(name = "task_done")
    var taskDone: Boolean = false
)