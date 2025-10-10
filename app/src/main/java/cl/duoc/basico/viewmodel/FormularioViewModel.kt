package cl.duoc.basico.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.duoc.basico.repository.FormularioRepository
import cl.duoc.basico.model.FormularioModel
import cl.duoc.basico.model.MensajesError

class FormularioViewModel : ViewModel() {
    private val repository = FormularioRepository()

    var formulario: FormularioModel by mutableStateOf( repository.getFormulario() )
    var mensajesError: MensajesError by mutableStateOf( repository.getMensajesError() )

    fun verificarFormulario(): Boolean {
        return verificarNombre() &&
                verificarCorreo() &&
                verificarEdad() &&
                verificarTerminos()
    }

    fun verificarNombre(): Boolean {
        if (!repository.validacionNombre()) {
            mensajesError.nombre = "El nombre no puede estar vacío"
            return false
        } else {
            mensajesError.nombre = ""
            return true
        }
        return repository.validacionNombre()
    }

    fun verificarCorreo(): Boolean {
        if(!repository.validacionCorreo()) {
            mensajesError.correo = "El correo no es válido"
            return false
        } else {
            mensajesError.correo = ""
            return true
        }
        return repository.validacionCorreo()
    }

    fun verificarEdad(): Boolean {
        if(!repository.validacionEdad()) {
            mensajesError.edad = "La edad debe ser un número entre 0 y 120"
            return false
        } else {
            mensajesError.edad = ""
            return true
        }
        return repository.validacionEdad()
    }

    fun verificarTerminos(): Boolean {
        if(!repository.validacionTerminos()) {
            mensajesError.terminos = "Debes aceptar los términos"
            return false
        } else {
            mensajesError.terminos = ""
            return true
        }
        return repository.validacionTerminos()
    }



}