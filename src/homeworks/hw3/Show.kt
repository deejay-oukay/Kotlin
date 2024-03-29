package homeworks.hw3

class Show(command: String): Command {
    private var parts = command.split(" ").toTypedArray()
    override fun isValid(): Boolean {
        if (parts.isEmpty() || (parts.size != 2)){
            println("Недопустимое количество параметров к команде show")
            return false
        }
        return true
    }

    fun run() {
        val person: Person? = Book().getByName(parts[1])
        if (person != null)
            println(person)
    }
}