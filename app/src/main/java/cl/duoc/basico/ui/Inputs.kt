package cl.duoc.basico.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inputs() {
    var texto by remember { mutableStateOf("") }
    var radioSeleccionado by remember { mutableStateOf(0) }
    val opcionesRadio = listOf("Opción 1", "Opción 2")
    var dropdownExpandido by remember { mutableStateOf(false) }
    val opcionesDropdown = listOf("Uno", "Dos", "Tres", "Cuatro", "Cinco")
    var dropdownSeleccionado by remember { mutableStateOf(opcionesDropdown[0]) }
    var checkMarcado by remember { mutableStateOf(false) }
    var sliderValor by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        OutlinedTextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Texto") },
            modifier = Modifier.Companion.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Companion.Text)
        )

        Spacer(modifier = Modifier.Companion.height(16.dp))

        Text("Radio Button:")
        opcionesRadio.forEachIndexed { index, opcion ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = radioSeleccionado == index,
                    onClick = { radioSeleccionado = index }
                )
                Text(opcion)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        ExposedDropdownMenuBox(
            expanded = dropdownExpandido,
            onExpandedChange = { dropdownExpandido = !dropdownExpandido }
        ) {
            OutlinedTextField(
                value = dropdownSeleccionado,
                onValueChange = {},
                readOnly = true,
                label = { Text("Dropdown") },
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = dropdownExpandido,
                onDismissRequest = { dropdownExpandido = false }
            ) {
                opcionesDropdown.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion) },
                        onClick = {
                            dropdownSeleccionado = opcion
                            dropdownExpandido = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkMarcado,
                onCheckedChange = { checkMarcado = it }
            )
            Text("Acepto los términos")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Valor del slider: ${sliderValor.toInt()}")
        Slider(
            value = sliderValor,
            onValueChange = { sliderValor = it },
            valueRange = 0f..100f
        )
    }
}