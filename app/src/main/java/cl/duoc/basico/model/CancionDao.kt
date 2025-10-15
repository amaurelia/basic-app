package cl.duoc.basico.model

import androidx.room.*

@Dao
interface CancionDao {
    @Query("SELECT * FROM canciones LIMIT 3")
    suspend fun getAll(): List<Cancion>

    @Insert
    suspend fun insert(cancion: Cancion)

    @Update
    suspend fun update(cancion: Cancion)

    @Delete
    suspend fun delete(cancion: Cancion)
}
