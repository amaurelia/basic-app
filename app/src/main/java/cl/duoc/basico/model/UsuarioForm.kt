package cl.duoc.basico.model

data class UsuarioForm(
    var nombre: String = "",
    var correo: String = "",
    var aceptaTerminos: Boolean = false,
    var quiereNotificaciones: Boolean = false,
    var edad: Int? = null
)

data class UsuarioFormError(
    val nombre: String? = null,
    val correo: String? = null,
    val edad: String? = null,
    val terminos: String? = null
)
