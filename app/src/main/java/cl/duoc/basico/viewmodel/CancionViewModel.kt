package cl.duoc.basico.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.duoc.basico.model.Cancion
import cl.duoc.basico.repository.CancionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CancionViewModel(private val repository: CancionRepository) : ViewModel() {

    val nombre = MutableStateFlow("")
    val autor = MutableStateFlow("")
    val genero = MutableStateFlow("")

    val canciones = MutableStateFlow<List<Cancion>>(emptyList())
    // ...

    init {
        cargarCanciones()
    }

    private fun cargarCanciones() {
        viewModelScope.launch {
            canciones.value = repository.getAll()
        }
    }

    fun agregarCancion(cancion: Cancion) {
        viewModelScope.launch {
            repository.insert(cancion)
            cargarCanciones()
        }
    }

    fun actualizarCancion(cancion: Cancion) {
        viewModelScope.launch {
            repository.update(cancion)
            cargarCanciones()
        }
    }

    fun eliminarCancion(cancion: Cancion) {
        viewModelScope.launch {
            repository.delete(cancion)
            cargarCanciones()
        }
    }
}
