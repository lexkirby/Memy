package com.universae.memy.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.universae.memy.notesData.Note
import com.universae.memy.notesData.NoteDAO
import com.universae.memy.taskData.Task
import com.universae.memy.taskData.TaskDAO
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

/*Creamos una clase abstracta que extienda de la clase RoomDatabase, la marcamos como base de datos
con la anotación @Database, le pasamos como entities las clases que hemos marcado como tablas,
le indicamos la versión de la base de datos y marcamos como false el exportar el schema
de la base de datos */
@Database(entities = [Task::class, Note::class], version = 1, exportSchema = false)
abstract class MemyDatabase : RoomDatabase() {

    /* Especificamos las interfaces que se usarán para acceder a los datos*/
    abstract val taskInt: TaskDAO
    abstract val noteInt: NoteDAO

    /*Creamos el companion object para poder llamar al método getInstance sin
    haber creado una base de datos y dentro definimos el método para crear una si no existe ya */
    companion object {
        /*Marcamos la variable INSTANCE como @Volatile para que los cambios sean visibles
        para todos los hilos de inmediato */
        @Volatile
        private var INSTANCE: MemyDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(context: Context): MemyDatabase {
            /*Usamos synchronized para que el bloque de código solo se pueda ejecutar por
            un único hilo al mismo tiempo */
            synchronized(this) {
                var instance = INSTANCE
                /*Creamos la base de datos si no existe*/
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MemyDatabase::class.java,
                        "memy_database"
                    ).build()
                    INSTANCE = instance

                }
                return instance
            }
        }

    }
}