package seminars.s4.task4

import kotlin.math.sqrt

public class ComplexNumber private constructor(@JvmField val re: Double, @JvmField val im: Double) {
    companion object {
        @JvmStatic
        fun create(re: Double, im: Double): ComplexNumber {
            return ComplexNumber(re, im)
        }
    }
}

fun ComplexNumber.abs(): Double = sqrt(re * re + im * im)

@Throws(DivisionByZeroException::class)
fun ComplexNumber.div(b: ComplexNumber): ComplexNumber {
    if (b.re == 0.0 && b.im == 0.0) {
        throw DivisionByZeroException()
    }

    val divisor = b.re * b.re + b.im * b.im
    return ComplexNumber.create(
        (re * b.re + im * b.im) / divisor,
        (im * b.re - re * b.im) / divisor
    )
}