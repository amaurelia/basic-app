package cl.duoc.basico.ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextoInvertido() {

    var texto by rememberSaveable { mutableStateOf("") }

    // val textoInvertido by remember { derivedStateOf { texto.reversed() } }
    val textoInvertido by remember  { mutableStateOf(texto.reversed()) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Ingrese texto") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text("Invertido: $textoInvertido")

    }

}