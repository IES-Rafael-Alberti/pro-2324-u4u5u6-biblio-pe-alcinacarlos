class GestorBiblioteca(
    private val catalogo: MutableList<ElementoBiblioteca<Any?>>,
    private val registroPrestamos:IGestorPrestamos
) {
    fun agregarElementoBiblioteca(elementoBiblioteca: ElementoBiblioteca<Any?>){
        catalogo.add(elementoBiblioteca)
    }
    fun eliminarElementoBiblioteca(elementoBiblioteca: ElementoBiblioteca<Any?>){
        catalogo.remove(elementoBiblioteca)
    }
    fun registrarPrestamo(elementoBiblioteca: ElementoBiblioteca<Any?>, usuario: Usuario){
        if (consultarDisponibilidad(elementoBiblioteca)) elementoBiblioteca.estado = Estado.PRESTADO
        registroPrestamos.registrarPrestamo(usuario, elementoBiblioteca)
    }
    fun devolverElementoBiblioteca(elementoBiblioteca: ElementoBiblioteca<Any?>, usuario: Usuario){
        if (!consultarDisponibilidad(elementoBiblioteca)) elementoBiblioteca.estado = Estado.DISPONIBLE
        registroPrestamos.devolverPrestamo(usuario,elementoBiblioteca)
    }
    fun consultarHistorialElementoBiblioteca(elementoBiblioteca: ElementoBiblioteca<Any?>): MutableList<Usuario> {
        return registroPrestamos.consultarHistorialElementoBiblioteca(elementoBiblioteca)
    }
    fun consultarHistorialUsuario(usuario: Usuario):List<MutableList<ElementoBiblioteca<Any?>>>{
        return registroPrestamos.consultarHistorialUsuario(usuario)
    }

    private fun consultarDisponibilidad(elementoBiblioteca: ElementoBiblioteca<Any?>):Boolean{
        return elementoBiblioteca.estado != Estado.PRESTADO
    }

    fun retornarEnFuncionEstado(estado: String): List<ElementoBiblioteca<Any?>> {
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