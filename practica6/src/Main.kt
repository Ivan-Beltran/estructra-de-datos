import java.io.File

fun LeerArchivo(ruta:String):String{
    val archivo=File(ruta)

    return archivo.readText()
}

fun EscribirArchivo(ruta: String,contenido:String){
    val archivo=File(ruta)
    archivo.writeText(contenido)
}

fun AgregarTexto(ruta: String,contenido:String){
    val archivo=File(ruta)
    archivo.appendText(contenido)
}

fun main(args:Array<String>){
    //ejemplo 1: leer archivo
    val ruta="documentos/archivo.txt"
    val contenido= LeerArchivo(ruta)

    println(contenido)
    print("\n")

    //ejemplo 2: crear archivo
    val ruta2="documentos/archivo2.txt"
    println("escriba el contenido para su archivo de texto")
    val contenido2= readLine()?:""

    EscribirArchivo(ruta2,contenido2)
    println("archivo creado exitosamente")
    print("\n")

    //ejemplo 3: agregando texto
    println("ingrese el texo que desea añadir al archivo")
    val contenido3= readLine()?:""
    AgregarTexto(ruta2,contenido3)
    println("texto añadido exitosamente")

}

