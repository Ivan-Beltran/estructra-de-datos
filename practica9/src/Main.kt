fun fibonacci(n:Int):Int{
    return if(n<=1){
        n
    }else{
        fibonacci(n-1)+fibonacci(n-2)
    }
}

fun sumaRecursiva(n:Int):Int{
    return  if(n<=1){
        1
    }else{
        n+sumaRecursiva(n-1)
    }
}

fun sumaLista(lista:List<Int>):Int{
    return if(lista.isEmpty()){
        0
    }else{
        lista[0]+sumaLista(lista.drop(1))
    }
}

fun main(args:Array<String>){
    //ejemplo fibonacci
    val numero:Int=5
    val numeroLista=listOf(1,3,4,5)
    println("\n ejemplo 1")
    print(fibonacci(numero))

    println("\n ejemplo 2")
    println("la suma de 1 a $numero es ${sumaRecursiva(numero)}")

    println("\n ejemplo 3")
    println("la suma de la lista es : ${sumaLista(numeroLista)}")

}