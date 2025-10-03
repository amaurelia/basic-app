import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cl.duoc.basico.repository.UsuarioRepository

@Composable
fun VerUsuariosScreen() {
    val listaUsuarios = UsuarioRepository.obtenerUsuarios()
    LazyColumn {
        items(listaUsuarios) { usuario ->
            Text(usuario.mostrarInfo())
        }
    }
}