// recursividad

fun findMax(number:List<Int>):Int{
    tailrec fun findMaxtailrep(index:Int,currentMax:Int):Int{
        if(index==number.size){
            return  currentMax
        }
        val newMax=if(number[index]>currentMax) number[index] else currentMax
        return findMaxtailrep(index+1,newMax)
    }
    require(number.isNotEmpty()){"no puede estar vacio"}
    return findMaxtailrep(0,number[0])
}


fun main(){
    val numbers= listOf(10,12,5,4,2,6)
    println("el numero mayor de la lista es : ${findMax(numbers)}")
}