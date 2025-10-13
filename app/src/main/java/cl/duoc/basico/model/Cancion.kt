package cl.duoc.basico.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "canciones")
data class Cancion(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val autor: String,
    val genero: String
)
