package cl.duoc.basico.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.android.gms.location.LocationServices
import com.google.maps.android.compose.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.CameraPosition

@Composable
fun GoogleMaps() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){


        val miUbicacion = LatLng(-33.49936500787212, -70.61654033901539)


        val nombreLugar1 = "Lugar 1"
        val lugar1 = LatLng(-33.497672632070476, -70.6126025410391)

        val nombreLugar2 = "Lugar 2"
        val lugar2 = LatLng(-33.50104607891704, -70.61707122623334)

        val nombreLugar3 = "Lugar 3"
        val lugar3 = LatLng(-33.49774554586376, -70.6178305190539)

        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(miUbicacion, 15f)
        }


        GoogleMap(
            modifier = Modifier.height(300.dp).fillMaxWidth(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = lugar1),
                title = nombreLugar1
            )
            Marker(
                state = MarkerState(position = lugar2),
                title = nombreLugar2
            )
            Marker(
                state = MarkerState(position = lugar3),
                title = nombreLugar3
            )
        }

    }
}

@SuppressLint("MissingPermission")
private fun getLastLocation(
    context: Context,
    fusedLocationClient: com.google.android.gms.location.FusedLocationProviderClient,
    onLocationResult: (Location?) -> Unit
) {
    fusedLocationClient.lastLocation
        .addOnSuccessListener { location: Location? ->
            onLocationResult(location)
        }
        .addOnFailureListener {
            onLocationResult(null)
        }
}
