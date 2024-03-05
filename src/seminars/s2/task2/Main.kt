package seminars.s2.task2

//Построить иерархию классов таким образом, чтобы после
//выполнения функции main был выведен корректный результат
//вычисления 3 формул.
//fun printOperationResult(operation: Operation) {
//    val result = operation.calculate()
//    println(result)
//}
//fun main() {
//    // ФорȀуǿы 1-3
//}
//
//Формула 1
//// Соответствует форȀуǿе 4 + 2.5 * 2
//printOperationResult(
//    Plus(
//        Value(4.0),
//        Multiply(
//            Value(2.5),
//            Value(2.0)
//        )
//    )
//)
//
//Формула 2
//// Соответствует форȀуǿе (1 + 3.5) * (2.5 + 2)
//printOperationResult(
//    Multiply(
//        Plus(
//            Value(1.0),
//            Value(3.5)
//        ),
//        Plus(
//            Value(2.5),
//            Value(2.0)
//        )
//    )
//)
//
//Формула 3
//// Соответствует форȀуǿе 10
//printOperationResult(
//    Value(10.0)
//)

fun printOperationResult(operation: Operation) {
    val result = operation.calculate()
    println(result)
}

sealed interface Operation {
    fun calculate(): Double
}

fun main() {
    // Соответствует форȀуǿе 4 + 2.5 * 2
    printOperationResult(
        Plus(
            Value(4.0),
            Multiply(
                Value(2.5),
                Value(2.0)
            )
        )
    )
    // Соответствует форȀуǿе (1 + 3.5) * (2.5 + 2)
    printOperationResult(
        Multiply(
            Plus(
                Value(1.0),
                Value(3.5)
            ),
            Plus(
                Value(2.5),
                Value(2.0)
            )
        )
    )

    // Соответствует форȀуǿе 10
    printOperationResult(
        Value(10.0)
    )
}

class Multiply(val left:Operation, val right: Operation): Operation {
    override fun calculate(): Double = left.calculate()*right.calculate()

}

class Value(val value: Double): Operation {
    override fun calculate() = value

}

class Plus(val left:Operation, val right: Operation) : Operation {
    override fun calculate(): Double = left.calculate()+right.calculate()
}
