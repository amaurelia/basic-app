package cl.duoc.basico

import AgregarUsuarios
import CamaraFotos
import GPS
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cl.duoc.basico.ui.Login
import cl.duoc.basico.ui.Modal
import cl.duoc.basico.ui.Navegacion
import cl.duoc.basico.ui.TocarPantalla
import cl.duoc.basico.ui.theme.BasicoTheme
import cl.duoc.basico.ui.Formulario


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicoTheme{
                Modal()
                //Formulario()
                //Login()
                //Navegacion()
                //CamaraFotos()
                //ModalScreen()
                //GPS()
                //AgregarUsuarios()
                // TocarPantalla()
            }
        }
    }

   /* private val viewModel = InicioViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicoTheme {
                MainScreen()
                // Pagina1()
                // ModalScreen()
                // InicioScreen(viewModel)
                // UbicacionGPSUI()
                // CrearUsuarioScreen()
                // VerUsuariosScreen()
                // PantallaUsuarios()
            }
        }
    }*/

}
