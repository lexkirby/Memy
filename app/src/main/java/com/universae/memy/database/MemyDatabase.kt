package com.universae.memy.database

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room
import com.universae.memy.taskData.Task
import com.universae.memy.notesData.Note
import com.universae.memy.notesData.NoteDAO
import com.universae.memy.taskData.TaskDAO
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Task::class, Note::class], version = 1, exportSchema = false)
abstract class MemyDatabase : RoomDatabase() {
    abstract val taskInt: TaskDAO
    abstract val noteInt: NoteDAO

    companion object
    @Volatile
    private var INSTANCE: MemyDatabase? = null

    @OptIn(InternalCoroutinesApi::class)
    fun getInstance(context: Context): MemyDatabase {
        synchronized(this) {
            var instance = INSTANCE
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