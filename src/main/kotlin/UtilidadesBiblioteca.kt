import java.util.UUID;

class UtilidadesBiblioteca() {
    fun generarIdentificadorUnico():String{
        val myUuid = UUID.randomUUID()
        return myUuid.toString()

    }
}