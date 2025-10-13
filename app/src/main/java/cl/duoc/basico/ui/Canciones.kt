package cl.duoc.basico.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import cl.duoc.basico.model.Cancion
import cl.duoc.basico.viewmodel.CancionViewModel
import androidx.compose.ui.unit.dp

@Composable
fun Canciones(viewModel: CancionViewModel) {
    val canciones by viewModel.canciones.collectAsState()
    val nombre by viewModel.nombre.collectAsState()
    val autor by viewModel.autor.collectAsState()
    val genero by viewModel.genero.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(value = nombre, onValueChange = { viewModel.nombre.value = it }, label = { Text("Nombre") })
        OutlinedTextField(value = autor, onValueChange = { viewModel.autor.value = it }, label = { Text("Autor") })
        OutlinedTextField(value = genero, onValueChange = { viewModel.genero.value = it }, label = { Text("Género") })
        Button(onClick = {
            viewModel.agregarCancion(Cancion(nombre = nombre, autor = autor, genero = genero))
            viewModel.nombre.value = ""; viewModel.autor.value = ""; viewModel.genero.value = ""
        }) {
            Text("Agregar Canción")
        }
        Spacer(modifier = Modifier.height(16.dp))
        canciones.forEach { cancion ->
            Text("${cancion.nombre} - ${cancion.autor} (${cancion.genero})")
        }
    }
}
