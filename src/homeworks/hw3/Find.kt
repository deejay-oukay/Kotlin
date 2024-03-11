package homeworks.hw3

class Find(command: String): Command {
    private var parts = command.split(" ").toTypedArray()
    override fun isValid(): Boolean {
        if (parts.isEmpty() || (parts.size != 2)){
            println("Недопустимое количество параметров к команде find")
            return false
        }
        return true
    }

    fun run() {
        val persons = Book().findByPhoneOrEmail(parts[1])
        for (person in persons)
            println(person.toString())
    }
}