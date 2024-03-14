class GestorBiblioteca(
    private val catalogo: MutableList<ElementoBiblioteca>,
    private val registroPrestamos:IGestorPrestamos
) {
    fun agregarElementoBiblioteca(elementoBiblioteca: ElementoBiblioteca){
        catalogo.add(elementoBiblioteca)
    }
    fun eliminarElementoBiblioteca(elementoBiblioteca: ElementoBiblioteca){
        catalogo.remove(elementoBiblioteca)
    }
    fun registrarPrestamo(elementoBiblioteca: ElementoBiblioteca, usuario: Usuario){
        if (consultarDisponibilidad(elementoBiblioteca)) elementoBiblioteca.estado = Estado.PRESTADO
        registroPrestamos.registrarPrestamo(usuario, elementoBiblioteca)
    }
    fun devolverElementoBiblioteca(elementoBiblioteca: ElementoBiblioteca, usuario: Usuario){
        if (!consultarDisponibilidad(elementoBiblioteca)) elementoBiblioteca.estado = Estado.DISPONIBLE
        registroPrestamos.devolverPrestamo(usuario,elementoBiblioteca)
    }
    fun consultarHistorialElementoBiblioteca(elementoBiblioteca: ElementoBiblioteca): MutableList<Usuario> {
        return registroPrestamos.consultarHistorialElementoBiblioteca(elementoBiblioteca)
    }
    fun consultarHistorialUsuario(usuario: Usuario):List<MutableList<ElementoBiblioteca>>{
        return registroPrestamos.consultarHistorialUsuario(usuario)
    }

    private fun consultarDisponibilidad(elementoBiblioteca: ElementoBiblioteca):Boolean{
        return elementoBiblioteca.estado != Estado.PRESTADO
    }

    fun retornarEnFuncionEstado(estado: String): List<ElementoBiblioteca> {
        return when(estado.lowercase()){
            "disponibles" -> {
                catalogo.filter { it.estado == Estado.DISPONIBLE }
            }
            "prestados" -> catalogo.filter { it.estado == Estado.PRESTADO }
            else -> {
                catalogo
            }
        }
    }

}