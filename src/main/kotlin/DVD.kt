class DVD(
    override val titulo:String,
    val musical:Boolean,
    override var estado: Estado = Estado.DISPONIBLE,
    override val id:String = UtilidadesBiblioteca().generarIdentificadorUnico()
):Prestable, ElementoBiblioteca<Any?>(id, titulo, estado) {
    init {
        require(titulo.isNotBlank()){ "El título no puede estar vacio"}
    }

    override fun devolver() {
        estado = Estado.DISPONIBLE
    }

    override fun prestar() {
        estado = Estado.PRESTADO
    }

    override fun toString(): String {
        return "Revista: $titulo, ID: $id, Estado: $estado, Autor: $musical"
    }
}