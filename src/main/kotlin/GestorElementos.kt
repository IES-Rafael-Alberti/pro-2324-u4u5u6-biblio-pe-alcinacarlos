class GestorElementos<T : ElementoBiblioteca<T>> {

    private val elementos: MutableList<T> = mutableListOf()
    fun agregar(elemento: T) {
        elementos.add(elemento)
    }
    fun eliminar(id: String) {
        elementos.removeIf { it.id == id }
    }

    fun obtenerTodos(): List<T> {
        return elementos.toList()
    }
    fun filtrarPorCriterio(criterio: (T) -> Boolean): List<T> {
        return elementos.filter(criterio)
    }
}