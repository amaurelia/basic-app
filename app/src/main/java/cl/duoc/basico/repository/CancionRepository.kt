package cl.duoc.basico.repository

import cl.duoc.basico.model.Cancion
import cl.duoc.basico.model.CancionDao

class CancionRepository(private val dao: CancionDao) {
    suspend fun getAll() = dao.getAll()
    suspend fun insert(cancion: Cancion) = dao.insert(cancion)
    suspend fun update(cancion: Cancion) = dao.update(cancion)
    suspend fun delete(cancion: Cancion) = dao.delete(cancion)
}
