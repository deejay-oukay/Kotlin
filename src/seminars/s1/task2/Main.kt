package seminars.s1.task2
/*
sumAll принимает переменное число аргументов типа Int.
Возвращает  сумму всех чисел, либо 0, если не передан ни один аргумент.

createOutputString формирует строку, используя параметры name, age и isStudent.
У параметров age и isStudent есть значения по умолчанию.

multiplyBy принимает два числа типа Int и возвращает их произведение.
Вместо первого числа, можно передать null, в этом случае функция должна вернуть null.

sumAll = 26
sumAll = 0
sumAll = 27
Alice has age of 42
Bob has age of 23
student Carol has age of 19
Daniel has age of 32
null
12
*/
fun main() {
    println("sumAll = ${sumAll(1, 5, 20)}")
    println("sumAll = ${sumAll()}")
    println("sumAll = ${sumAll(2, 3, 4, 5, 6, 7)}")
    println(createOutputString("Alice"))
    println(createOutputString("Bob", 23))
    println(createOutputString(isStudent = true, name = "Carol", age = 19))
    println(createOutputString("Daniel", 32, isStudent = null))
    println(multiplyBy(null, 4))
    println(multiplyBy(3, 4))
}

fun sumAll(vararg numbers: Int) = if (numbers.isEmpty()) 0 else numbers.sum()

fun createOutputString(name: String, age: Int = 42, isStudent: Boolean? = false): String {
    var result = ""
    if (isStudent == true)
        result = "student "
    result += "$name has age of $age"
    return result
}

fun multiplyBy (a: Int?, b: Int): Int? {
    if (a == null)
        return null
    return a*b
}