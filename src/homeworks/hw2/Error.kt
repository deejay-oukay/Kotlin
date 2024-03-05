package homeworks.hw2

class Error: Command {
    override fun isValid(): Boolean {
        println("Команда не распознана")
        return true
    }
}