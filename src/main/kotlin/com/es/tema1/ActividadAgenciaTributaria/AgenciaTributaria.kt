package com.es.tema1.ActividadAgenciaTributaria

import org.w3c.dom.Element
import org.w3c.dom.Node
import java.nio.file.Path
import javax.xml.parsers.DocumentBuilderFactory

fun mostrarObjetos(noticiasXML: Path): List<Noticia> {
    val listaNoticias = mutableListOf<Noticia>()

    //Crea el documentBuilder para leer el archivo XML
    val documentBuilderFactory = DocumentBuilderFactory.newInstance()
    val documentBuilder = documentBuilderFactory.newDocumentBuilder()

    //Lee y parsea el archivo XML
    val document = documentBuilder.parse(noticiasXML.toFile())

    //Normalizar el documento XML (asegura que las estructuras estén bien formadas)
    document.documentElement.normalize()

    //Obtenemos el nodo raiz del documento
    val root = document.documentElement

    //Obtenemos una lista de todos los nodos "items" (noticias) del XML
    val noticias = root.getElementsByTagName("item")

    for (i in 0..<noticias.length) {
        val noticiaNode = noticias.item(i)

        //Verificar que el nodo es de tipo elemento (asegura que sea un nodo válido)
        if (noticiaNode.nodeType == Node.ELEMENT_NODE) {
            val noticia = noticiaNode as Element

            val title = noticia.getElementsByTagName("title").item(0).textContent
            val link = noticia.getElementsByTagName("link").item(0).textContent
            val guid = noticia.getElementsByTagName("guid").item(0).textContent
            val pubDate = noticia.getElementsByTagName("pubDate").item(0).textContent
            val description = noticia.getElementsByTagName("description").item(0).textContent

            val noticiaCreate = Noticia(title, link, guid, pubDate, description)

            listaNoticias.add(noticiaCreate)
        }
    }
    return listaNoticias
}

fun main() {
    val fichXML = Path.of("src/main/resources/agenciaTributaria.xml")
    val listaNoticias = mostrarObjetos(fichXML)

    for ((index, noticia) in listaNoticias.withIndex()) {
        println("Noticia ${index + 1}:")
        println("\t- Título: ${noticia.title.trim()}")
        println("\t- Enlace: ${noticia.link}")
        println("\t- Fecha de publicación: ${noticia.pubDate}")
        println("\t- Descripción: ${noticia.description.trim().replace("<p>","").replace("</p>","")}")
    }
}