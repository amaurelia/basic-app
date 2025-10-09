package cl.duoc.basico.model

data class UsuarioForm(
    var nombre: String = "",
    var correo: String = "",
    var terminos: Boolean = false,
    var edad: Int? = null
)