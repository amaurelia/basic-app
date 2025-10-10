package cl.duoc.basico


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cl.duoc.basico.ui.*
import cl.duoc.basico.ui.theme.BasicoTheme
import cl.duoc.basico.viewmodel.FormularioViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = FormularioViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicoTheme{ // <- aquí va el nombre de TU TEMA, lo puedes encontrar en ui/theme/Theme.kt
                Formulario(viewModel)
                //BotonCargando()
                //TextoInvertido()
                //Persistencia()
                //UsuarioFormScreen()
                //Modal()
                // Formulario()
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



}
