class RegistroPrestamos(
    private val prestamosActuales:MutableMap<ElementoBiblioteca<Any?>, Usuario?> = mutableMapOf(),
    private val historialPrestamos:MutableMap<ElementoBiblioteca<Any?>, MutableList<Usuario>> = mutableMapOf()
):IGestorPrestamos {
    private fun inicializarUsuarioEnSistema(elementoBiblioteca: ElementoBiblioteca<Any?>){
        historialPrestamos[elementoBiblioteca] = mutableListOf()

    }
    override fun registrarPrestamo(usuario: Usuario, elementoBiblioteca: ElementoBiblioteca<Any?>){
        if (historialPrestamos[elementoBiblioteca] == null) inicializarUsuarioEnSistema(elementoBiblioteca)
        usuario.agregarElementoBiblotecaPrestado(elementoBiblioteca)
        prestamosActuales[elementoBiblioteca] = usuario
        historialPrestamos[elementoBiblioteca]!!.add(usuario)
    }
    override fun devolverPrestamo(usuario:Usuario, elementoBiblioteca: ElementoBiblioteca<Any?>){
        if (historialPrestamos[elementoBiblioteca] == null) inicializarUsuarioEnSistema(elementoBiblioteca)
        usuario.quitarElementoBiblotecaPrestado(elementoBiblioteca)
        prestamosActuales[elementoBiblioteca] = null
    }

    override fun consultarHistorialElementoBiblioteca(elementoBiblioteca: ElementoBiblioteca<Any?>): MutableList<Usuario> {
        return historialPrestamos[elementoBiblioteca]!!
    }

    override fun consultarHistorialUsuario(usuario: Usuario): List<MutableList<ElementoBiblioteca<Any?>>> {
        val usuarios = mutableSetOf<Usuario>()
        historialPrestamos.values.forEach{ it.forEach { usuarios.add(it) }}
        val resultado:MutableMap<Usuario, MutableList<ElementoBiblioteca<Any?>>> = mutableMapOf()
        for (nombreUsuario in usuarios){
            val usuarios = historialPrestamos.filter { (usuario, listalibros) -> listalibros.any{it == nombreUsuario} }.keys
            resultado[nombreUsuario] = usuarios.toMutableList()
        }
        return resultado.filter { it.key == usuario }.values.toList()
    }

}