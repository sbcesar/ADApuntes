package com.es.tema1

import org.w3c.dom.Node
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import org.w3c.dom.Element
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import kotlin.io.path.notExists


fun main(args: Array<String>) {

//    //LECTURA DE FICHEROS XML
//    //EL OBJETIVO ES PARSEAR EL FICHERO XML A ARBOL DOM
//    //1º INSTANCIAR UN OBJETO DocumentBuilderFactory
//    val dbf = DocumentBuilderFactory.newInstance()
//
//    //2º CON EL DBF PODEMOS CREAR UN OBJETO DEL TIPO DocumentBuilder
//    val db = dbf.newDocumentBuilder()
//
//    //3º CUANDO TENEMOS EL DB YA PODEMOS PARSEAR NUESTRO DOCUMENTO (PRIMERO NECESITAMOS EL FILE)
//    val ficheroXML = Path.of("src").resolve("main/resources/productos.xml")
//
//    //AHORA SI PARSEAMOS
//    val document = db.parse(ficheroXML.toFile())
//
//    //DENTRO DE LA LASE DOCUMENT TENEMOS DOS METODOS IMPORTANTES
//    //1 PARA OBTENER EL ELEMENTO ROOT
//    val root = document.documentElement
//
//    //DENTRO DE LA LASE ELEMENT TENEMOS DOS METODOS IMPORTANTES
//    //1 PARA NORMALIZAR EL ARBOL
//    root.normalize()
//
//    //2 PARA OBTENER ELEMENTOS POR SU NOMBRE DE ETIQUETA
//    val listaNodos = root.getElementsByTagName("producto")
//
//    //CUANDO TENEMOS LA NODELIST PODEMOS ITERAR SOBRE ELLA
//    for (i in 0..listaNodos.length) {
//        //PARA OBTENER UN ITEM EN PARTICULAR ACCEDEMOS A TRAVÉS DEL INDEX
//        val nodo = listaNodos.item(i)
//
//        //PARA ACCEDER AL TIPO DE NODO USAMOS .NODETYPE
//        if (nodo.nodeType == Node.ELEMENT_NODE) {
//            //CASTEAMOS A ELEMENT
//            val nodoElemento = nodo as Element
//
//            //PODEMOS BUSCAR LOS ELEMENTOS QUE NOS CONVIENEN
//            val elementoNombre = nodoElemento.getElementsByTagName("nombre")
//            val elementoPrecio = nodoElemento.getElementsByTagName("precio")
//
//            //UNA VEZ TENEMOS EL ELEMENTO QUE QUEREMOS PODEMOS ACCEDER A SU CONTENIDO
//            val textContentNombre = elementoNombre.item(0).textContent
//            val textContentPrecio = elementoPrecio.item(0).textContent.toDouble()
//
//            //IMPRIMO
//            println("Producto ${i}:\n\t - nombre: ${textContentNombre}\n\t - precio ${textContentPrecio}")
//        }
//    }



//    val raiz = Path.of("src")
//    val rutaFichero = raiz.resolve("main").resolve("resources").resolve("CarpetaPrueba").resolve("prueba.txt")
//    val rutaDestino = raiz.resolve("main").resolve("resources").resolve("CarpetaPrueba").resolve("documentoDestino.txt")
//
//    if (rutaDestino.notExists()) {
//        //Crea los directorios hasta la ruta destino
//        Files.createDirectory(rutaDestino.parent)
//        //Crea el fichero documentoDestino.txt
//        Files.createFile(rutaDestino)
//    }
//
//    //Una vez creado el fichero y la ruta hacia el mismo, puedo copiar
//    Files.copy(rutaFichero,rutaDestino, StandardCopyOption.REPLACE_EXISTING)


    /*
    Actividad Practica1

    val carpeta = File("C:\\Users\\cesar\\Desktop\\2DAM\\ADA\\ADA_2425\\src\\main\\resources\\CarpetaPrueba")

    accion(carpeta)

     */


    // 1º Declarar variable que almacene el File
    /*
    val separador = System.getProperty("file.separator")    //Caracter que separa los componentes de una ruta
    val separador2 = File.separator
    val userDir = System.getProperty("user.dir")    //Directorio utilizandose
    val userHome = System.getProperty("user.home")  //Directorio home
    val osName = System.getProperty("os.name")      //Nombre del sistema operativo

    println(separador)
    println(separador2)
    println(userDir)
    println(userHome)
    println(osName)

    var ficheroPrueba = File("" +
            "C:${separador}" +
            "Users${separador}" +
            "cesar${separador}" +
            "Desktop${separador}" +
            "2DAM${separador}" +
            "ADA${separador}" +
            "ADA_2425${separador}" +
            "src${separador}" +
            "main${separador}" +
            "resources${separador}" +
            "prueba.txt"
    )

    if (ficheroPrueba.exists()) {
        println("Fichero existe")
    } else {
        println("Fichero no existe")
    }
     */

    /*
    Path.of("")          //construir rutas a los ficheros (de forma más segura) (se pueden usar tanto rutas absolutas como relativas) (multiargumentos: ("/home", "usuario", "documentos", "archivo.txt"))
    resolve()            //modificar la ruta de archivos o directorios
    Files.copy()         //copiar archivos o rutas
     */


}






























