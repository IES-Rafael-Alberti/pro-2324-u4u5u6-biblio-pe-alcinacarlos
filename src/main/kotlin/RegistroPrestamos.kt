import org.pebiblioteca.Libro

class RegistroPrestamos(
    private val prestamosActuales:MutableMap<Libro, Usuario?> = mutableMapOf(),
    private val historialPrestamos:MutableMap<Libro, MutableList<Usuario>> = mutableMapOf()
) {
    private fun inicializarUsuarioEnSistema(libro: Libro){
        historialPrestamos[libro] = mutableListOf()

    }
    fun registrarPrestamo(usuario: Usuario, libro: Libro){
        if (historialPrestamos[libro] == null) inicializarUsuarioEnSistema(libro)
        usuario.agregarLibroPrestado(libro)
        prestamosActuales[libro] = usuario
        historialPrestamos[libro]!!.add(usuario)
    }
    fun devolverPrestamo(usuario:Usuario, libro: Libro){
        if (historialPrestamos[libro] == null) inicializarUsuarioEnSistema(libro)
        usuario.quitarLibroPrestado(libro)
        prestamosActuales[libro] = null
    }

    fun consultarHistorialLibro(libro: Libro): MutableList<Usuario> {
        return historialPrestamos[libro]!!
    }

    fun consultarHistorialUsuario(usuario: Usuario): List<MutableList<Libro>> {
        val usuarios = mutableSetOf<Usuario>()
        historialPrestamos.values.forEach{ it.forEach { usuarios.add(it) }}
        val resultado:MutableMap<Usuario, MutableList<Libro>> = mutableMapOf()
        for (nombreUsuario in usuarios){
            val usuarios = historialPrestamos.filter { (usuario, listalibros) -> listalibros.any{it == nombreUsuario} }.keys
            resultado[nombreUsuario] = usuarios.toMutableList()
        }
        return resultado.filter { it.key == usuario }.values.toList()
    }

}