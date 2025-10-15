package cl.duoc.basico.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import cl.duoc.basico.model.Cancion
import cl.duoc.basico.viewmodel.CancionViewModel
import androidx.compose.ui.unit.dp
import cl.duoc.basico.R

@Composable
fun Canciones(viewModel: CancionViewModel) {
    val canciones by viewModel.canciones.collectAsState()
    val nombre by viewModel.nombre.collectAsState()
    val autor by viewModel.autor.collectAsState()
    val genero by viewModel.genero.collectAsState()


    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "My TOP",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.casette),
            contentDescription = "Casette",
            modifier = Modifier
                .width(250.dp)
                .height(175.dp)
        )

        OutlinedTextField(value = nombre, onValueChange = { viewModel.nombre.value = it }, label = { Text("Nombre") })
        OutlinedTextField(value = autor, onValueChange = { viewModel.autor.value = it }, label = { Text("Autor") })
        OutlinedTextField(value = genero, onValueChange = { viewModel.genero.value = it }, label = { Text("Género") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.agregarCancion(Cancion(nombre = nombre, autor = autor, genero = genero))
            viewModel.nombre.value = ""; viewModel.autor.value = ""; viewModel.genero.value = ""
        }) {
            Text("Agregar Canción")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(canciones) { cancion ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = cancion.nombre,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = cancion.autor,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = cancion.genero,
                        modifier = Modifier.weight(1f)
                    )
                }
                Divider()
            }
        }
    }
}
