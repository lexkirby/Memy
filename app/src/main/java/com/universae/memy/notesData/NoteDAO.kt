package com.universae.memy.notesData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/*Marcamos la interfaz para su uso como Data Access Object con la anotación @Dao
* para definir los métodos de acceso a datos */
@Dao
interface NoteDAO {
    /*Marcamos los métodos con suspend para que cuando se invoquen se lancen como
    hilos en segundo plano a través de coroutines. Los que contienen LiveData no hace falta
    marcarlos porque Room ya usa hilos en segundo plano para métodos que devuelven ese tipo de datos*/

    /*Método para insertar datos a la tabla Note */
    @Insert
   suspend fun insert(note: Note)

    /*Método para actualizar datos de la tabla Note */
    @Update
   suspend fun update(note: Note)

    /*Método para eliminar datos de la tabla Note */
    @Delete
   suspend fun delete(note: Note)

    /*Método para hacer un query SQL a la tabla Note y que devuelva un objeto LiveData de la
    tabla Note según su ID que notifica cuando los datos cambian */

    @Query("SELECT * FROM notes_table WHERE noteId = :noteId")
    fun get(noteId: Long) : LiveData<Note>

    /*Método para hacer un query SQL a la tabla Note y que devuelva una lista de todos los
    objetos LiveData de la tabla Note que notifica cuando los datos cambian */
    @Query("SELECT * FROM notes_table ORDER BY noteId DESC")
    fun getAll(): LiveData<List<Note>>
}