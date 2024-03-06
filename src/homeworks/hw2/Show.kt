package homeworks.hw2
import kotlin.reflect.*

class Show: Command {
    override fun isValid(): Boolean {
        return true
    }

    fun run() {
        println(Person::last.toString())
    }
}