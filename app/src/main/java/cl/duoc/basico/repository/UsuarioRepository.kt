package cl.duoc.basico.repository

import cl.duoc.basico.model.Usuario
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

object UsuarioRepository {
    private var _usuarios by mutableStateOf(listOf<Usuario>())
    val usuarios: List<Usuario> get() = _usuarios
    private var nextId = 1

    fun crearNuevoUsuario(
        nombre: String,
        apellido: String,
        nacionalidad: String,
        telefono: String,
        correo: String
    ): Usuario {
        val usuario = Usuario(
            id = nextId++,
            nombre = nombre,
            apellido = apellido,
            nacionalidad = nacionalidad,
            telefono = telefono,
            correo = correo
        )
        _usuarios = _usuarios + usuario
        return usuario
    }

    fun obtenerUsuarios(): List<Usuario> = usuarios
}
