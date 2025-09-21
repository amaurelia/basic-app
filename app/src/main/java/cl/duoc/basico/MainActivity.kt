package cl.duoc.basico

import PerfilConFotoUI
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cl.duoc.basico.ui.InicioScreen
import cl.duoc.basico.ui.theme.BasicoTheme
import cl.duoc.basico.viewmodel.InicioViewModel


class MainActivity : ComponentActivity() {

    private val viewModel = InicioViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicoTheme {
                //InicioScreen(viewModel)
                PerfilConFotoUI()
            }
        }
    }

}
