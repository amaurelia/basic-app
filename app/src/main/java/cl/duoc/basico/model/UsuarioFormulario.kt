package cl.duoc.basico.model


data class UsuarioFormulario(
    var nombre: String = "",
    var correo: String = "",
    var edad: String = "",
    var terminos: Boolean = false
)