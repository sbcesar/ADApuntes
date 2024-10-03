package com.es.tema1

import org.w3c.dom.Node
import java.nio.file.Path
import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory

//Imprimir los empleados con un salario mayor a 2000.0
//Funcion que reciba el XML de empleados y devuelva una lista de objetos empleado
//RSS Agencia Tributaria (Moodle) -> Hacer una funion que reciba dicho RSS (en XML) y que devuelva una lista de objetos de tipo Noticia (corresponde a los elementos <item>) (title, link, guid, pubDate, description)

fun mostrarObjetos(empleadosXML: Path): List<Empleados> {

    val listaEmpleados = mutableListOf<Empleados>()

    val documentBuilderFactory = DocumentBuilderFactory.newInstance()
    val documentBuilder = documentBuilderFactory.newDocumentBuilder()
    val document = documentBuilder.parse(empleadosXML.toFile())
    document.documentElement.normalize()

    val root = document.documentElement
    val empleados = root.getElementsByTagName("empleado")

    for (i in 0..<empleados.length) {

        val empleadoNode = empleados.item(i)

        if (empleadoNode.nodeType == Node.ELEMENT_NODE) {
            val empleado = empleadoNode as Element

            val apellido = empleado.getElementsByTagName("apellido").item(0).textContent
            val dep = empleado.getElementsByTagName("dep").item(0).textContent.toInt()
            val salario = empleado.getElementsByTagName("salario").item(0).textContent.toDouble()

            val empleadoAgregar = Empleados(apellido, dep, salario)

            listaEmpleados.add(empleadoAgregar)
        }
    }

    return listaEmpleados
}


fun main() {
    val fichXML = Path.of("src/main/resources/practica1XML.xml")
    val documentBuilderFactory = DocumentBuilderFactory.newInstance()
    val documentBuilder = documentBuilderFactory.newDocumentBuilder()
    val document = documentBuilder.parse(fichXML.toFile())
    document.documentElement.normalize()

    val root = document.documentElement
    val empleados = root.getElementsByTagName("empleado")

    for (i in 0..<empleados.length) {

        val empleadoNode = empleados.item(i)

        if (empleadoNode.nodeType == Node.ELEMENT_NODE) {
            val empleado = empleadoNode as Element

            val apellido = empleadoNode.getElementsByTagName("apellido").item(0).textContent
            val dep = empleado.getElementsByTagName("dep").item(0).textContent.toInt()
            val salario = empleado.getElementsByTagName("salario").item(0).textContent.toDouble()

            if (salario > 2000.0) {
                println("Empleado ${i}:\n\t - apellido: ${apellido}\n\t - dep: ${dep}\n\t - salario: ${salario}")
            }
        }
    }

    val listaEmpleados = mostrarObjetos(fichXML)
    println(listaEmpleados)
}




