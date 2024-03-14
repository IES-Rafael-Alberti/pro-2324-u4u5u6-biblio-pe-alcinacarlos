class RegistroPrestamos(
    private val prestamosActuales:MutableMap<ElementoBiblioteca, Usuario?> = mutableMapOf(),
    private val historialPrestamos:MutableMap<ElementoBiblioteca, MutableList<Usuario>> = mutableMapOf()
):IGestorPrestamos {
    private fun inicializarUsuarioEnSistema(elementoBiblioteca: ElementoBiblioteca){
        historialPrestamos[elementoBiblioteca] = mutableListOf()

    }
    override fun registrarPrestamo(usuario: Usuario, elementoBiblioteca: ElementoBiblioteca){
        if (historialPrestamos[elementoBiblioteca] == null) inicializarUsuarioEnSistema(elementoBiblioteca)
        usuario.agregarElementoBiblotecaPrestado(elementoBiblioteca)
        prestamosActuales[elementoBiblioteca] = usuario
        historialPrestamos[elementoBiblioteca]!!.add(usuario)
    }
    override fun devolverPrestamo(usuario:Usuario, elementoBiblioteca: ElementoBiblioteca){
        if (historialPrestamos[elementoBiblioteca] == null) inicializarUsuarioEnSistema(elementoBiblioteca)
        usuario.quitarElementoBiblotecaPrestado(elementoBiblioteca)
        prestamosActuales[elementoBiblioteca] = null
    }

    override fun consultarHistorialElementoBiblioteca(elementoBiblioteca: ElementoBiblioteca): MutableList<Usuario> {
        return historialPrestamos[elementoBiblioteca]!!
    }

    override fun consultarHistorialUsuario(usuario: Usuario): List<MutableList<ElementoBiblioteca>> {
        val usuarios = mutableSetOf<Usuario>()
        historialPrestamos.values.forEach{ it.forEach { usuarios.add(it) }}
        val resultado:MutableMap<Usuario, MutableList<ElementoBiblioteca>> = mutableMapOf()
        for (nombreUsuario in usuarios){
            val usuarios = historialPrestamos.filter { (usuario, listalibros) -> listalibros.any{it == nombreUsuario} }.keys
            resultado[nombreUsuario] = usuarios.toMutableList()
        }
        return resultado.filter { it.key == usuario }.values.toList()
    }

}