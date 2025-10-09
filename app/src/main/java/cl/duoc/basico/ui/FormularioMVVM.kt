package cl.duoc.basico.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cl.duoc.basico.model.UsuarioFormulario


@Composable
fun FormularioMVVM() {


    val formulario = remember { UsuarioFormulario() }

    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var terminos by remember { mutableStateOf(false) }

    var abrirModal by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = formulario.nombre,
            onValueChange = { formulario.nombre = it },
            label = { Text("Ingresa nombre") },
        )
        OutlinedTextField(
            value = formulario.correo,
            onValueChange = { formulario.correo = it },
            label = { Text("Ingresa correo") },
        )
        OutlinedTextField(
            value = formulario.edad,
            onValueChange = { formulario.edad = it },
            label = { Text("Ingresa edad") },
        )
        Checkbox(
            checked = formulario.terminos,
            onCheckedChange = { formulario.terminos = it }
        )
        Text("Acepta los términos")

        Button(
            enabled = true,
            onClick = { abrirModal = true }
        ) {
            Text("Enviar")
        }

        if (abrirModal) {
            AlertDialog(
                onDismissRequest = { },
                title = { Text("Confirmación") },
                text = { Text("Formulario enviado correctamente") },
                confirmButton = {
                    Button(onClick = { abrirModal = false }) { Text("OK") }
                }
            )
        }

    }
}
