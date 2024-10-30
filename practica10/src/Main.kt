class Nodo(val pregunta:String,val respuesta:String?=null){
    var izquierdo:Nodo?=null
    var derecho:Nodo?=null
}

class ArbolBinarioRPG {
    var raiz: Nodo

    init {
        val mago = Nodo("", "Eres un mago")
        val arquero = Nodo("", "Eres un arquero")
        val guerrero = Nodo("", "Eres un guerrrero")
        val Asesino = Nodo("", "Eres un asesino")

        val magia = Nodo("prefieres usar magia ?")
        magia.izquierdo = mago
        magia.derecho = arquero

        val armas = Nodo("prefieres usar armas")
        armas.izquierdo = guerrero
        armas.derecho = Asesino

        raiz = Nodo("prefieres combate a distancia")
        raiz.izquierdo=magia
        raiz.derecho=armas

    }
}

fun juego(nodo:Nodo?){
    if(nodo==null) return

    if(nodo.respuesta != null){
        println(nodo.respuesta)
        return
    }

    println(nodo.pregunta + "(si/no)")
    val respuesta= readln()?.lowercase()

    if(respuesta=="si"){
        juego(nodo.izquierdo)
    } else{
        juego(nodo.derecho)
    }
}

fun main(){
    val jugador=ArbolBinarioRPG()
    println("bienvenido al juego de rpg")
    juego(jugador.raiz)
}