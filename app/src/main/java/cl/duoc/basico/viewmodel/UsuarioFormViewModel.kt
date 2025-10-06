package cl.duoc.basico.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import cl.duoc.basico.model.UsuarioForm
import cl.duoc.basico.model.UsuarioFormError

class UsuarioFormViewModel : ViewModel() {

    val TAG = "MyActivity" // Define a tag for your logs

    private val _form = MutableStateFlow(UsuarioForm())
    val form: StateFlow<UsuarioForm> = _form

    private val _errors = MutableStateFlow(
        UsuarioFormError(
            nombre = "El nombre es obligatorio",
            correo = "El correo es obligatorio",
            edad = "La edad es obligatoria",
            terminos = "Debes aceptar los términos"
        )
    )
    val errors: StateFlow<UsuarioFormError> = _errors

    fun onNombreChange(value: String) {
        _form.value = _form.value.copy(nombre = value)
        validate()
    }

    fun onCorreoChange(value: String) {
        _form.value = _form.value.copy(correo = value)
        validate()
    }

    fun onEdadChange(value: Int?) {
        _form.value = _form.value.copy(edad = value)
        validate()
    }

    fun onAceptaTerminosChange(value: Boolean) {
        _form.value = _form.value.copy(aceptaTerminos = value)
        validate()
    }

    fun onQuiereNotificacionesChange(value: Boolean) {
        _form.value = _form.value.copy(quiereNotificaciones = value)
    }

    fun isFormValid(errors: UsuarioFormError): Boolean {
        Log.d(TAG, "in isFormValid")
        Log.d(TAG, "errors.nombre: ${errors.nombre}")
        Log.d(TAG, "errors.correo: ${errors.correo}")
        Log.d(TAG, "errors.edad: ${errors.edad}")
        Log.d(TAG, "errors.terminos: ${errors.terminos}")
        return errors.nombre == null && errors.correo == null && errors.edad == null && errors.terminos == null
    }

    private fun validate() {
        val f = _form.value
        _errors.value = UsuarioFormError(
            nombre = if (f.nombre.isBlank()) "El nombre es obligatorio" else null,
            correo = if (!f.correo.matches(Regex("^[\\w.-]+@[\\w.-]+\\.\\w+$"))) "Correo inválido" else null,
            edad = if (f.edad == null || f.edad !in 18..99) "Edad entre 18 y 99" else null,
            terminos = if (!f.aceptaTerminos) "Debes aceptar los términos" else null
        )
    }
}