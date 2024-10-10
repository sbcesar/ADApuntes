package com.es.tema1

import org.w3c.dom.Element
import org.w3c.dom.Node
import java.nio.file.Path
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun getProductos(fichXML: Path): List<Productos> {

    val listaProductos = mutableListOf<Productos>()

    val documentBuilderFactory = DocumentBuilderFactory.newInstance()
    val documentBuilder = documentBuilderFactory.newDocumentBuilder()
    val document = documentBuilder.parse(fichXML.toFile())
    document.documentElement.normalize()

    val root = document.documentElement
    val productos = root.getElementsByTagName("producto")

    for (i in 0..<productos.length) {
        val productoNode = productos.item(i)

        if (productoNode.nodeType == Node.ELEMENT_NODE) {
            val producto = productoNode as Element

            val nombreProducto = producto.getElementsByTagName("nombre").item(0).textContent
            val precioProducto = producto.getElementsByTagName("precio").item(0).textContent.toDouble() * 1.21

            val productosCreadted = Productos(nombreProducto,precioProducto)

            listaProductos.add(productosCreadted)
        }
    }
    return listaProductos
}

fun createXML(fileDestineXML: Path, listaProductos: List<Productos>) {
    val factory = DocumentBuilderFactory.newInstance()
    val builder = factory.newDocumentBuilder()
    val imp = builder.domImplementation

    val document = imp.createDocument(null,"productos",null)

    for (producto in listaProductos) {
        val productoP = document.createElement("producto")
        document.documentElement.appendChild(productoP)

        val nombreP1 = document.createElement("nombre")
        val precioP1 = document.createElement("precio")

        val textoNombre = document.createTextNode(producto.nombre)
        val textoPrecio = document.createTextNode(producto.precio.toString())

        nombreP1.appendChild(textoNombre)
        precioP1.appendChild(textoPrecio)
        productoP.appendChild(nombreP1)
        productoP.appendChild(precioP1)
    }

    val source = DOMSource(document)
    val result = StreamResult(fileDestineXML.toFile())
    val transformer = TransformerFactory.newInstance().newTransformer()

    transformer.setOutputProperty(OutputKeys.INDENT,"yes")
    transformer.transform(source,result)
}

fun main() {
    val fileXML = Path.of("src/main/resources/productosWrite.xml")
    val fileDestineXML = Path.of("src/main/resources/productosWrite2.xml")

    val listaProductos = getProductos(fileXML)
    createXML(fileDestineXML,listaProductos)
}