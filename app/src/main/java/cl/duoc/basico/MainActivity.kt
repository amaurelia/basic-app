package cl.duoc.basico


import GPS
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cl.duoc.basico.model.AppDatabase
import cl.duoc.basico.repository.CancionRepository
import cl.duoc.basico.ui.*
import cl.duoc.basico.ui.theme.BasicoTheme
import cl.duoc.basico.viewmodel.CancionViewModel
import cl.duoc.basico.viewmodel.FormularioViewModel
import androidx.room.Room

class MainActivity : ComponentActivity() {

    private val viewModelForm = FormularioViewModel()
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "canciones_db"
        ).build()
    }
    private val repository by lazy { CancionRepository(db.cancionDao()) }
    private val viewModelCanciones by lazy { CancionViewModel(repository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicoTheme{ // <- aquí va el nombre de TU TEMA, lo puedes encontrar en ui/theme/Theme.kt
                GoogleMaps()
                //Canciones(viewModelCanciones)
                //Formulario(viewModelForm)
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
                // GPS()
                //AgregarUsuarios()
                // TocarPantalla()
            }
        }
    }



}
