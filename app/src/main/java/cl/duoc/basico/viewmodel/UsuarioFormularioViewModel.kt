package cl.duoc.basico.viewmodel

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import cl.duoc.basico.model.UsuarioForm
import cl.duoc.basico.model.UsuarioFormError
import cl.duoc.basico.model.UsuarioFormulario
import cl.duoc.basico.repository.FormularioRepository


class UsuarioFormularioViewModel : ViewModel() {
    private val repository = FormularioRepository()

    fun verificarFormulario() {
        repository.validacionNombre()
    }

}