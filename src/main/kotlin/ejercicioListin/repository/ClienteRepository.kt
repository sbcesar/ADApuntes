package ejercicioListin.repository

import ejercicioListin.model.Cliente
import java.io.BufferedReader
import java.io.BufferedWriter
import java.nio.file.Files
import java.nio.file.Path

class ClienteRepository(
    private val rutaFichero: Path
) {

    //Agrega un telefono nuevo
    fun addTelf(nombre: String, tlfn: String): Cliente? {

        //Comprueba si el fichero existe
        if (Files.notExists(rutaFichero)) {
            //Crea todos los directorios necesarios
            Files.createDirectories(rutaFichero.parent)
            //Crea el fichero
            Files.createFile(rutaFichero)
        }

        //Leer el fichero
        val br: BufferedReader = Files.newBufferedReader(rutaFichero)
        var existe = false
        br.use {
            it.forEachLine {
                line ->
                val lineaSeparada = line.split(",")
                if (lineaSeparada[1] == tlfn) {
                    existe = true
                }
            }
        }

        if (existe) {
            return null
        } else {

            //Si no existe debemos añadir el telefono al cliente
            val bw: BufferedWriter = Files.newBufferedWriter(rutaFichero)
            val cliente = Cliente(nombre, tlfn)
            bw.use {
                it.append("${cliente.nombre},${cliente.tlfn}\n")
            }
            return cliente
        }
    }

    //Consulta los telefonos de un cliente
    fun getTelf(nombre: String): String {
        val br: BufferedReader = Files.newBufferedReader(rutaFichero)
        val existe = false

        br.use {
            it.forEachLine {
                line ->
                val lineaSeparada = line.split(",")
                if (lineaSeparada.contains(nombre)) {
                    
                }
            }
        }
        return ""
    }

    //Borra un telefono de un cliente
    fun deleteTlf() {


    }
}