package com.es.tema1

import java.io.File

fun accion(directorio: File) {
    val file = File(directorio, "prueba1.txt")
    var reader: List<String>
    if (directorio.isDirectory()) {
        file.createNewFile()
        file.writeText("Hola Mundo")
        reader = file.readLines()
        println(reader)
    }
    if (directorio.isFile) {
        reader = directorio.readLines()
        println(reader)
    }
}