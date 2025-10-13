package cl.duoc.basico.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Cancion::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cancionDao(): CancionDao
}
