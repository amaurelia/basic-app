package cl.duoc.basico.repository

import cl.duoc.basico.model.UsuarioFormulario


class  FormularioRepository {

    private var formulario = UsuarioFormulario()


    fun validacionNombre(): Boolean {
        var respuesta = false
        if(formulario.nombre==""){
                respuesta = true
        }
        return respuesta
    }


}
