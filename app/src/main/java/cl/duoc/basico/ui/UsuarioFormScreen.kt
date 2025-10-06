package cl.duoc.basico.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cl.duoc.basico.viewmodel.UsuarioFormViewModel

@Composable
fun UsuarioFormScreen(viewModel: UsuarioFormViewModel = viewModel()) {
    val form by viewModel.form.collectAsState()
    val errors by viewModel.errors.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    var showSnackbar by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = form.nombre,
            onValueChange = viewModel::onNombreChange,
            label = { Text("Nombre") },
            isError = errors.nombre != null,
            supportingText = { errors.nombre?.let { Text(it, color = MaterialTheme.colorScheme.error) } }
        )
        OutlinedTextField(
            value = form.correo,
            onValueChange = viewModel::onCorreoChange,
            label = { Text("Correo") },
            isError = errors.correo != null,
            supportingText = { errors.correo?.let { Text(it, color = MaterialTheme.colorScheme.error) } }
        )
        OutlinedTextField(
            value = form.edad?.toString() ?: "",
            onValueChange = { viewModel.onEdadChange(it.toIntOrNull()) },
            label = { Text("Edad") },
            isError = errors.edad != null,
            supportingText = { errors.edad?.let { Text(it, color = MaterialTheme.colorScheme.error) } }
        )
        Checkbox(
            checked = form.aceptaTerminos,
            onCheckedChange = viewModel::onAceptaTerminosChange
        )
        Text("Acepta los términos")
        errors.terminos?.let { Text(it, color = MaterialTheme.colorScheme.error) }

        Checkbox(
            checked = form.quiereNotificaciones,
            onCheckedChange = viewModel::onQuiereNotificacionesChange
        )
        Text("¿Quiere recibir notificaciones?")

        //viewModel.isFormValid(errors),*/
        Button(
            enabled = true,
            onClick = {
                if (viewModel.isFormValid(errors)) {
                    showDialog = true
                } else {
                    showSnackbar = true
                }
            }
        ) {
            Text("Enviar")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Confirmación") },
                text = { Text("Formulario enviado correctamente") },
                confirmButton = {
                    Button(onClick = { showDialog = false }) { Text("OK") }
                }
            )
        }

        if (showSnackbar) {
            Snackbar(
                action = {
                    Button(onClick = { showSnackbar = false }) { Text("Cerrar") }
                }
            ) { Text("Corrige los errores antes de enviar") }
        }
    }
}
