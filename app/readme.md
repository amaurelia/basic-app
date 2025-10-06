# Proyecto Kotlin - Desarrollo Mobile Duoc

**Autor:** Alvaro Maurelia  
**Contacto:** al.maurelia@profesor.duoc.cl

Este proyecto está diseñado para enseñar desarrollo móvil con Kotlin y Jetpack Compose, siguiendo la arquitectura MVVM.

## Cómo crear un nuevo proyecto

1. Abre Android Studio y haz clic en `New Project`.
2. Selecciona la opción `Empty Activity`.
3. Crea las siguientes carpetas al mismo nivel que `MainActivity`:
    - `ui`
    - `ui/theme`
    - `model`
    - `repository`
    - `viewmodel`

Esta estructura permite organizar el código siguiendo el patrón MVVM.

## ¿Qué es MVVM?

**MVVM (Model-View-ViewModel)** es una arquitectura que separa la lógica de negocio, la gestión de datos y la interfaz de usuario:

- **Model:** Define las estructuras de datos y reglas de negocio.
- **View:** Contiene la interfaz gráfica (pantallas, composables).
- **ViewModel:** Gestiona los datos y la lógica, comunicando la vista con el modelo.
- **Repository:** Encapsula el acceso a fuentes de datos (API, base de datos).

## Estructura de carpetas

- **ui:** Pantallas y componentes visuales.
- **ui/theme:** Personalización de colores y estilos.
- **model:** Clases de datos y entidades.
- **repository:** Acceso y gestión de datos.
- **viewmodel:** Lógica de presentación y gestión de estados.

## Archivos principales en `ui`

- **Formulario.kt:** Formulario con campo de texto, radio buttons, dropdown, checkbox y slider.
- **Modal.kt:** Ejemplo de modal usando `AlertDialog`.
- **GPS.kt:** Obtiene y muestra la localización del dispositivo.
- **ImagenGato.kt:** Muestra imágenes desde recursos.
- **AgregarUsuarios.kt:** Pantalla para agregar nuevos git pulusuarios al sistema.
- **Login.kt:** Pantalla de inicio de sesión.
- **Navegacion.kt:** Ejemplo de navegación entre pantallas.
- **CamaraFotos.kt:** Permite tomar fotos usando la cámara del dispositivo.
- **TocarPantalla.kt:** Detecta y responde a toques en la pantalla.
- **VerUsuarios.kt:** Muestra la lista de usuarios registrados.
- **Theme.kt:** Configuración de colores y temas visuales.

## Objetivo

Que los alumnos comprendan y practiquen la creación de interfaces modernas, el manejo de estados y la integración de funcionalidades comunes en apps móviles, aplicando buenas prácticas de arquitectura.

---

**¡Explora los archivos y experimenta con los componentes para aprender desarrollo mobile en Kotlin!**
