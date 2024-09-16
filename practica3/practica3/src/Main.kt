/*
single responsability principie(srp)
*/

//ejemplo de no uso de srp
/*
class Factura(val items: List<Item>){
    fun calcularTotal():Double{
        return items.sumOf { it.precio }
    }

    fun generarReporte():String{
        return "reporte de la factura"
    }
}
 */

class Factura(val items:String){
    fun cacularTotal():String{
        return "este es el total"
    }
}

class ReporteDeFactura(){
    fun generarReporte():String{
        return "reporte"
    }
}

//OPEN/CLOSE PRINCIPIE (OCP)

open class Empleado(val nombre:String, val horasTrabajada: Int, val precioHora: Double){
    open fun CalcularSalario():Double{
        return horasTrabajada*precioHora
    }
}

class EmpleadoConBono(nombre:String,horasTrabajada: Int,precioHora: Double,val bono:Int):Empleado(nombre,horasTrabajada,precioHora){
    override fun CalcularSalario(): Double {
        return super.CalcularSalario()+bono
    }
}

// LISKOV SUBSTITUTION PRINCIPIE (LSP)

fun main(args:Array<String>){
    fun imprimirSalario(empleado:Empleado){
        println("el salario de ${empleado.nombre} es de ${empleado.CalcularSalario()}")
    }

    val empleado= Empleado("ivan",40,12.0)
    val empleadoBono=EmpleadoConBono("josue",40,12.3,70)

    imprimirSalario(empleado)
    imprimirSalario(empleadoBono)
}

//INTERFACE SEGREGATION PRINCIPIE (ISP)

interface Trabajador{
    fun trabajar()
}

interface Asistente {
    fun asistir()
}
interface Reportero{
    fun generarReporte()
}

class Programador():Trabajador{
    override fun trabajar(){
       println("el trabajador es programador")
    }
}

class albañil():Trabajador{
    override fun trabajar(){
        println("el trabajador es albañil")
    }
}

//DEPENDENCY INVERSION PRINCIPIE (DIP)

interface Notificaciones{
    fun EnviarNotificaciones(mensaje:String)
}

class ServicioEmails():Notificaciones{
    override fun EnviarNotificaciones(mensaje: String) {
        println("enviando email con el mensaje: ${mensaje}")
    }
}

class Notificacion(val servicio:Notificaciones){
    fun enviarNotificaciones(){
        servicio.EnviarNotificaciones("notificacion importante")
    }
}