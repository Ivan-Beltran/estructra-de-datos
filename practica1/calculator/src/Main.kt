import kotlin.math.pow

fun main(){
    var numberOne:Double?=null
    println("ingrese un primer numero")
    numberOne= readln().toDoubleOrNull()
    while(numberOne==null){
        println("numero invalido ingrese nuevamente el primer numero")
        numberOne= readln().toDoubleOrNull()
    }

    var numberTow:Double?=null
    println("ingrese segundo numero")
    numberTow= readln().toDoubleOrNull()
    while (numberTow==null){
        println("numero invalido ingrese nuevamente el segundo numero")
        numberTow= readln().toDoubleOrNull()
    }

    var operator:String
    println("ingrese operacion: +,-,*,/,^  nota: el simbolo ^representa una potencia")
    operator= readln().toString()
    while (operator=="" || (operator!="+"&& operator!="-"&& operator!="/"&& operator!="*"&& operator!="^")){
        println("operador invalido , ingresarlo nuevamente")
        operator= readln().toString()
    }

    calculate(numberOne,numberTow,operator)
}

fun calculate(numberOne:Double ,numberTow:Double, operator:String){
    var result= when(operator){
        "+"-> numberOne+numberTow
        "-"-> numberOne-numberTow
        "*"-> numberOne*numberTow
        "/"-> numberOne/numberTow
        "^"-> numberOne.pow(numberTow)
        else -> throw IllegalArgumentException("Operación desconocida")
    }

    return println("el resultado es $result")
}

