package seminars.s1.task3
//Написать программу, выводящую на экран фигуру из звёздочек.
//a – количество звёздочек на первой строчке;
//b – количество строк от первой до центральной и от центральной до последней;
//c – количество звёздочек, на которое увеличивается последовательность с каждой строкой.
//a=5, b=2, c=2
//a=1, b=3, c=2
//a=1, b=2, c=4
fun main() {
    stars(5,2,2)
    println()
    stars(1,3,2)
    println()
    stars(1,2,4)
    println()
}

fun stars(a: Int, b: Int, c: Int) {
    for (start in a..<a+b*c step c)
    {
        for (star in 1..start)
            print("*")
        println()
    }
    for (start in a+b*c downTo a step c)
    {
        for (star in 1..start)
            print("*")
        println()
    }
}

