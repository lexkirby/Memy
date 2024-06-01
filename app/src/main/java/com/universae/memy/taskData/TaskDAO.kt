package com.universae.memy.taskData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/*Marcamos la interfaz para su uso como Data Access Object con la anotación @Dao
* para definir los métodos de acceso a datos */
@Dao
interface TaskDAO {
    /*Marcamos los métodos con suspend para que cuando se invoquen se lancen como
    hilos en segundo plano a través de coroutines. Los que contienen LiveData no hace falta
    marcarlos porque Room ya usa hilos en segundo plano para métodos que devuelven ese tipo de datos*/

    /*Método para insertar datos a la tabla Task */
    @Insert
    suspend fun insert(task: Task)

    /*Método para actualizar datos de la tabla Task */
    @Update
    suspend fun update(task: Task)

    /*Método para eliminar datos de la tabla Task */
    @Delete
    suspend fun delete(task: Task)

    /*Método para hacer un query SQL a la tabla Note y que devuelva un objeto LiveData de la
  tabla Task según su ID que notifica cuando los datos cambian */
    @Query("SELECT * FROM task_table WHERE taskId = :taskId")
    fun get(taskId: Long) : LiveData<Task>

    /*Método para hacer un query SQL a la tabla Note y que devuelva una lista de todos los
     objetos LiveData de la tabla Task que notifica cuando los datos cambian */
    @Query("SELECT * FROM task_table ORDER BY taskId DESC")
    fun getAll(): LiveData<List<Task>>

}