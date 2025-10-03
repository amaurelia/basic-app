import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.duoc.basico.repository.UsuarioRepository

val listaUsuarios = UsuarioRepository.obtenerUsuarios()

@Composable
fun CrearUsuarioScreen(onUsuarioCreado: () -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var nacionalidad by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )
        OutlinedTextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text("Apellido") }
        )
        OutlinedTextField(
            value = nacionalidad,
            onValueChange = { nacionalidad = it },
            label = { Text("Nacionalidad") }
        )
        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") }
        )
        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") }
        )
        Button(
            onClick = {
                UsuarioRepository.crearNuevoUsuario(nombre, apellido, nacionalidad, telefono, correo)
                onUsuarioCreado()
                nombre = ""
                apellido = ""
                nacionalidad = ""
                telefono = ""
                correo = ""
            }
        ) {
            Text("Crear Usuario")
        }
    }
}