data class Tarea(val nombre: String, val prioridad:Int)

class NodoArbol(val tarea: Tarea){
    var izquierda: NodoArbol?=null
    var derecha:NodoArbol?=null
}

class ArbolTareas{
    private var raiz: NodoArbol?=null

    fun insertar(tarea: Tarea){
        raiz=insertarRecursivo(raiz,tarea)
    }

    private fun insertarRecursivo(actual:NodoArbol?,tarea: Tarea):NodoArbol{
        if(actual==null){
            return NodoArbol(tarea)
        }
        if(tarea.prioridad<actual.tarea.prioridad){
            actual.izquierda=insertarRecursivo(actual.izquierda,tarea)
        }else{
            actual.derecha=insertarRecursivo(actual.derecha,tarea)
        }
        return actual
    }


    fun mostrarEnOrden(){
        mostrarEnOrdenRecursivo(raiz)
    }
    fun mostrarEnOrdenRecursivo(nodo: NodoArbol?){
        if(nodo !=null){
            mostrarEnOrdenRecursivo(nodo.izquierda)
            println("tarea: ${nodo.tarea.nombre}, prioridad: ${nodo.tarea.prioridad}")
            mostrarEnOrdenRecursivo(nodo.derecha)
        }
    }
}

// Gestion de tareas
class CustomList<T> {
    private val elements = mutableListOf<T>()

    fun add(element:T):Boolean{
        return if(element !in elements){
            elements.add(element)
            println("tarea agregada exitosamente")
            true
        }
        else{
            println(" esta tarea ya existe")
            false
        }
    }

    fun remove(element: T):Boolean{
        return if(element in elements){
            elements.remove(element)
            println("tarea eliminada")
            true
        }
        else{
            println("esta tarea no existe")
            false
        }
    }

    fun showAll(){
        if(elements.isEmpty()){
            println("la lista esta vacia")
        }
        else{
            println("listea de tareas")
            elements.forEach{ println("${it}")}
        }
    }

    fun size():Int{
        return elements.size
    }

    fun GetAll():List<T>{
        return elements
    }
}

fun main(){
    val listaTareas=CustomList<Tarea>()
    val arbolTareas=ArbolTareas()
    var opcion:Int

    do{
        println("\nGestor de tareas")
        println("1. agregar tarea")
        println("2. eliminar tarea")
        println("3. ver tareas")
        println("4. ver lista de tareas ordenadas")
        println("5. salir")
        println("seleccione una opcion")
        opcion= readLine()?.toIntOrNull()?:0

        when(opcion){
            1->{
                println("ingrese el nombre de la nueva tarea")
                val nombre= readLine()?:""
                println("ingrese la prioridad de la nueva tarea")
                val prioridad= readLine()?.toIntOrNull()?:0
                val nuevaTarea=Tarea(nombre,prioridad)
                listaTareas.add(nuevaTarea)
                arbolTareas.insertar(nuevaTarea)
            }
            2->{
                if(listaTareas.size()>0){
                    println("seleccione la tarea a eliminar")
                    listaTareas.showAll()
                    println("ingrese el nombre exacto de la tarea: ")
                    val nombre= readLine()?:""
                    val elimiarTarea=listaTareas.GetAll().find { it.nombre==nombre}
                    if(elimiarTarea!=null){
                        listaTareas.remove((elimiarTarea))
                    }


                }else{
                    println("la tarea no esta en la lista")
                }
            }
            3->{
                listaTareas.showAll()
            }
            4->{
                println("lista de tareas ordenadas por prioridad")
                arbolTareas.mostrarEnOrden()
            }
            5-> println("saliendo del programa....")

            else-> println("opcion no valida,ingrese una ipcion valida")
        }
    }
    while (opcion!=4)
}