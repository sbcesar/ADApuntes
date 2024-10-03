package com.es.tema1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.nio.file.Files
import java.nio.file.Path

fun main() {

//    //BufferedReader
//    //Debemos crear/abrir un flujo de lectura de tipo BufferedReader
//    val ficheroPrueba = Path.of("src/main/resources/prueba.txt")
//    val br: BufferedReader = Files.newBufferedReader(ficheroPrueba)
//
//    //Una vez tengamos el flujo de lectura abierto, podemos consumirlo
//    br.forEachLine { line -> println(line) }
//    //IMPORTANTE CERRAR LOS FLUJOS, COÑO
//    br.close()
//
//    //Una manera más segura de recorrer todas las líneas es usando el .use que asegura que aunque haya excepxiones, se cierra el flujo
//    br.use { flujo -> flujo.forEachLine {
//        //line -> println(it)
//        println(it)
//    } }


    //BufferedWriter
    val ficheroPrueba2 = Path.of("src/main/resources/prueba2.txt")
    val bw: BufferedWriter = Files.newBufferedWriter(ficheroPrueba2)

    bw.use { flujo ->
        flujo.write("morri callate la boca")
        flujo.newLine()
        flujo.write("morri callate la boca")
    }

}