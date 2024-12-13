//algoritmos de busqueda
//busqueda lineal (secuencial)
fun linearSearch(array:List<Int>,target:Int):Int{
    for(i in array.indices) {
        if (array[i] == target) return i
    }
        return -1
}

fun binarySearch(array: List<Int>, target:Int):Int{
    var start=0
    var end=array.size-1

    while(start <=end){
        val mid=((start+end)/2)
        when{
            array[mid]==target-> return mid
            array[mid]<target -> start=mid+1
            else ->end=mid-1
        }
    }
    return  -1
}

fun main(){
    val numbers= listOf(1,24,567,8,97,56,45,34,343)
    val result=linearSearch(numbers,24)
    println("elemento encontrado en el indice : ${result}")

    val resultBinary=binarySearch(numbers,97)
    println("elemento encontrado en el indice ${resultBinary}")
}