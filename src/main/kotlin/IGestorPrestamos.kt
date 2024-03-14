interface IGestorPrestamos {
    fun registrarPrestamo(usuario: Usuario, elementoBiblioteca: ElementoBiblioteca<Any?>)
    fun devolverPrestamo(usuario:Usuario, elementoBiblioteca: ElementoBiblioteca<Any?>)

    fun consultarHistorialElementoBiblioteca(elementoBiblioteca: ElementoBiblioteca<Any?>): MutableList<Usuario>

    fun consultarHistorialUsuario(usuario: Usuario): List<MutableList<ElementoBiblioteca<Any?>>>
}