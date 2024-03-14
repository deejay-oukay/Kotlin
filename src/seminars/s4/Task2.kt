package seminars.s4

//1. Написать программу, которая принимает два аргумента командной строки и вычисляет их сумму.
//2. Написать свой класс исключения NotIntArgumentException(arg: String)
//3. Для вычисления суммы реализовать функцию
//   sum(a: String, b: String): Int
//4. В этой функции, при преобразовании строки в число, обработать исключение NumberFormatException
//   и заменить его на NotIntArgumentException.
//5. В функции main, при вызове функции sum, обработать как NotIntArgumentException,
//   так и IndexOutOfBoundsException (оно возникнет при обращении к массиву args по индексу в случае, если было
//   передано менее двух аргументов командной строки).

class NotIntArgumentException(message: String?): RuntimeException(message)

fun sum(num1: String, num2: String): Int{
    try {
        return num1.toInt() + num2.toInt()
    } catch (ex: NumberFormatException) {
        throw NotIntArgumentException(ex.message)
    }
}
fun main (vararg args: String){
    try {
        val num1 = args[0]
        val num2 = args[1]
        println(sum(num1,num2))
    } catch (ex: NotIntArgumentException) {
        println(ex.message)
    } catch (ex: IndexOutOfBoundsException) {
        println(ex.message)
    }
}

