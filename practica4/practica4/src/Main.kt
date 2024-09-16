//ejemplo 1
class Caja<T>(val contenido:T){
    fun obtenerContenido():T{
        return contenido
    }
}

//ejemplo 2
fun <T> imprimirDato(elemto:T){
    println(elemto)
}

//ejemplo 3
fun <T: Number>Sumar(a:T,b:T):Double{
    return a.toDouble()+b.toDouble()
}

//ejemplo 4

fun <T> ImprimirSiEsNumero(valor:T) where T:Number{
    println(valor.toDouble())
}



fun main (arg:Array<String>){

    val cajaINt=Caja(42)
    val cajaString=Caja("hola soy una cadena")
    val nombre="ivan"
    val entero=4444
    val suma= Sumar(10.75,45)

    println("*******ejemplo 1 *******")
    println(cajaINt.obtenerContenido())
    println(cajaString.obtenerContenido())
    println("******* fin del ejemplo 1 *******")

    println("\n*******ejemplo 2 *******")
    imprimirDato(nombre)
    imprimirDato(entero)
    println("******* fin del ejemplo 2 *******")

    println("\n*******ejemplo 3 *******")
    println("la suma es ${suma}")
    println("******* fin del ejemplo 3 *******")

    println("\n*******ejemplo 4 *******")
    ImprimirSiEsNumero(3.1416)
    println("******* fin del ejemplo 4 *******")
}


