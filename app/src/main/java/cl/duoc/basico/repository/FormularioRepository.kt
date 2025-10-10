package cl.duoc.basico.repository

import cl.duoc.basico.model.FormularioModel
import cl.duoc.basico.model.MensajesError


class  FormularioRepository {

    private var formulario = FormularioModel()
    private var errores = MensajesError()

    fun getFormulario():  FormularioModel = formulario
    fun getMensajesError():  MensajesError = errores


    fun cambiarNombre(nuevoNombre: String) {
        formulario.nombre = nuevoNombre
    }

    fun validacionNombre(): Boolean {
        if(formulario.nombre=="")
            return false
        else
            return true
    }

    fun validacionCorreo(): Boolean {
        if (!formulario.correo.matches(Regex("^[\\w.-]+@[\\w.-]+\\.\\w+$")))
            return false
        else
            return true
    }

    fun validacionEdad(): Boolean {
        val edadInt = formulario.edad.toIntOrNull()
        if (edadInt == null || edadInt < 0 || edadInt > 120)
            return false
        else
            return true
    }

    fun validacionTerminos(): Boolean {
        if (!formulario.terminos)
            return false
        else
            return true
    }


}
