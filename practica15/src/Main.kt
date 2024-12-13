import com.sun.jdi.Value
import kotlin.system.measureTimeMillis

//algoritmos de ordenamiento

//bubbleSort
fun bubbleSort(array:IntArray){
    val n=array.size
    for(i in 0 until n){
        for(j in 0 until n-i-1){
            if(array[j]>array[j+1]){
                val temp=array[j]
                array[j]=array[j+1]
                array[j+1]=temp
            }
        }
    }
}

//insertion sort
fun insertionSort(array:IntArray){
    for(i in 1 until array.size){
        val key=array[i]
        var j= i-1
        while(j>=0  && array[j]>key){
            array[j+1]=array[j]
            j-=1
        }
        array[j+1]=key
    }
}
//ordenamiento por seleccion
fun selectionSort(array:IntArray){
    val n=array.size
    for(i in 0 until n-1){
        var minIndex=i
        for(j in i+1 until n){
            if(array[j]<array[minIndex]){
                minIndex=j
            }
        }
        val temp=array[minIndex]
        array[minIndex]=array[i]
        array[i]=temp
    }
}

//quicksort

fun quickSort(array:IntArray,low:Int,high:Int){
    if(low<high){
        val pivot=partition(array,low,high)
        quickSort(array,low,pivot-1)
        quickSort(array,low+1,high)
    }
}
fun partition(array:IntArray,low:Int,high:Int):Int{
    val pivot=array[high]
    var i=(low-1)
    for(j in low until high){
        if(array[j]<=pivot){
            i++
            val temp =array[i]
            array[i]=array[high]
            array[j]=temp
        }
    }
    val temp=array[i+1]
    array[i+1]=array[high]
    array[high]=temp

    return i+1
}

//merge sort

fun mergeSort(array:IntArray){
    if(array.size<2)return
    val middle=array.size/2
    val left=array.copyOfRange(0,middle)
    val right=array.copyOfRange(middle,array.size)
    mergeSort(left)
    mergeSort(right)
    merge(array,left,right)
}
fun merge(array: IntArray,left:IntArray,right:IntArray){
    var i=0
    var j=0
    var k=0
    while(i<left.size && j<right.size){
        array[k++]=left[i++]
    }
    array[k++]=left[j++]

    while(i<left.size) array[k++]=left[i++]
    while (i<right.size) array[k++]=left[j++]

}

fun measureSortTime(algorith:(IntArray)->Unit, array: IntArray):Long{
    return measureTimeMillis{
        algorith(array.copyOf())
    }
}

fun main(){
    val smallList=(1..1000).toList().shuffled().toIntArray()
    val largeList=(1..10000).toList().shuffled().toIntArray()
    val orderList=(1..1000).toList().toIntArray()

    println("tiempos de ejecucion")
     val bubbleSmall=measureSortTime(::bubbleSort,smallList)
    val insertionSmall=measureSortTime(::insertionSort,smallList)
    val selectionSmall=measureSortTime(::selectionSort,smallList)

    println("bubble sort: $bubbleSmall")
    println("insertion sort : $insertionSmall")
    println("selection sort: $selectionSmall")
}