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
}

fun main(){
    val listaTareas=CustomList<String>()
    var opcion:Int

    do{
        println("\nGestor de tareas")
        println("1. agregar tarea")
        println("2. eliminar tarea")
        println("3. ver tareas")
        println("4. salir")
        println("seleccione una opcion")
        opcion= readLine()?.toIntOrNull()?:0

        when(opcion){
            1->{
                println("ingrese la nueva tarea")
                val nuevaTarea= readLine()?:""
                listaTareas.add(nuevaTarea)
            }
            2->{
                if(listaTareas.size()>0){
                    println("seleccione la tarea a eliminar")
                    listaTareas.showAll()
                    println("ingrese el nombre exacto de la tarea: ")
                    val eliminarTarea= readLine()?:""
                    listaTareas.remove((eliminarTarea))
                }else{
                    println("la tarea no esta en la lista")
                }
            }
            3->{
                listaTareas.showAll()
            }
            4-> println("saliendo del programa....")

            else-> println("opcion no valida,ingrese una ipcion valida")
        }
    }
    while (opcion!=4)
}