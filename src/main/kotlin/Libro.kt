package org.pebiblioteca

class Libro(
    val título:String,
    val autor:String,
    val fecha_de_publicación:Int,
    val temática:String,
    var estado:Estado = Estado.DISPONIBLE,
    val id:Int = generarId()
) {
    companion object{
        var id_companio = 0
        private fun generarId():Int{
            return ++id_companio
        }
    }
    init {
        require(título.isNotBlank()){ "El título no puede estar vacio"}
        require(autor.isNotBlank()){ "El autor no puede estar vacio"}
    }
}