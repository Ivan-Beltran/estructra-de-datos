fun main() {
    val numeros = Array(4) {0}
    var numeroMayor= 0

    for (i in numeros.indices) {
        while (true) {
            try {
                print("Ingresa un número entero (${i + 1}/4): ")
                numeros[i] = readLine()!!.toInt()
                break
            } catch (e: NumberFormatException) {
                println("Error: Debes ingresar un número entero válido.")
            }
        }

    }

    for(i in numeros.indices){
        if(numeros[i]>numeroMayor){
            numeroMayor=numeros[i]
        }
    }


    println("el numero mayor es: $numeroMayor")
}