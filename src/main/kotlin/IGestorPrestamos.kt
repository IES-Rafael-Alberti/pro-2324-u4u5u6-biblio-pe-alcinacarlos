interface IGestorPrestamos {
    fun registrarPrestamo(usuario: Usuario, elementoBiblioteca: ElementoBiblioteca)
    fun devolverPrestamo(usuario:Usuario, elementoBiblioteca: ElementoBiblioteca)

    fun consultarHistorialElementoBiblioteca(elementoBiblioteca: ElementoBiblioteca): MutableList<Usuario>

    fun consultarHistorialUsuario(usuario: Usuario): List<MutableList<ElementoBiblioteca>>
}