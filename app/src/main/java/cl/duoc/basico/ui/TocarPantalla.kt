package cl.duoc.basico.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
@Composable
fun TocarPantalla() {
    var playerPos by remember { mutableStateOf(Offset(100f, 100f)) }
    val playerSize = 80f

    var obstaclePos by remember { mutableStateOf(Offset(300f, 300f)) }
    val obstacleSize = 120f
    var obstacleVelocity by remember { mutableStateOf(Offset(6f, 5f)) }

    var obstacleColor by remember { mutableStateOf(Color.Red) }
    var touched by remember { mutableStateOf(false) }
    var hp by remember { mutableStateOf(100) }
    val maxHp = 100

    var canvasSize by remember { mutableStateOf(Size(0f, 0f)) }

    // Movimiento automático del obstáculo
    LaunchedEffect(obstaclePos, canvasSize) {
        if (hp > 0) {
            delay(16) // ~60 FPS
            var newPos = obstaclePos + obstacleVelocity
            var newVel = obstacleVelocity

            // Rebote en bordes
            if (newPos.x < 0f || newPos.x + obstacleSize > canvasSize.width) {
                newVel = Offset(-newVel.x, newVel.y)
                newPos = obstaclePos + newVel
            }
            if (newPos.y < 0f || newPos.y + obstacleSize > canvasSize.height) {
                newVel = Offset(newVel.x, -newVel.y)
                newPos = obstaclePos + newVel
            }
            obstaclePos = newPos
            obstacleVelocity = newVel
        }
    }

    // Detección de toque sobre el obstáculo
    fun isTouchingObstacle(newPos: Offset): Boolean {
        return newPos.x < obstaclePos.x + obstacleSize &&
                newPos.x + playerSize > obstaclePos.x &&
                newPos.y < obstaclePos.y + obstacleSize &&
                newPos.y + playerSize > obstaclePos.y
    }

    // Efecto para cambiar color temporalmente y reducir HP
    LaunchedEffect(touched) {
        if (touched && hp > 0) {
            obstacleColor = Color.Yellow
            hp = (hp - 5).coerceAtLeast(0)
            delay(500)
            obstacleColor = Color.Red
            touched = false
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures { tapOffset ->
                        val newPos = Offset(
                            tapOffset.x - playerSize / 2,
                            tapOffset.y - playerSize / 2
                        )
                        playerPos = newPos
                        if (isTouchingObstacle(newPos) && hp > 0) {
                            touched = true
                        }
                    }
                }
        ) {
            // Guardar tamaño del canvas
            canvasSize = size

            // Dibuja obstáculo
            drawRect(
                color = obstacleColor,
                topLeft = obstaclePos,
                size = Size(obstacleSize, obstacleSize)
            )
            // Dibuja personaje
            drawRect(
                color = Color.Blue,
                topLeft = playerPos,
                size = Size(playerSize, playerSize)
            )
            // Dibuja barra de vida sobre el obstáculo
            val barWidth = obstacleSize
            val barHeight = 16f
            val hpRatio = hp / maxHp.toFloat()
            drawRect(
                color = Color.Gray,
                topLeft = Offset(obstaclePos.x, obstaclePos.y - barHeight - 8f),
                size = Size(barWidth, barHeight)
            )
            drawRect(
                color = Color.Green,
                topLeft = Offset(obstaclePos.x, obstaclePos.y - barHeight - 8f),
                size = Size(barWidth * hpRatio, barHeight)
            )
        }
        // Mensaje de derrota
        if (hp == 0) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "¡El cuadrado rojo ha sido derrotado!",
                    color = Color.Red,
                    fontSize = 24.sp
                )
            }
        }
    }
}