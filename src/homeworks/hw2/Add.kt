package homeworks.hw2

class Add(command: String): Command {
    private var parts = command.split(" ").toTypedArray()
    override fun isValid(): Boolean {
        if (parts.isEmpty() || (parts.size != 4)){
            println("Недопустимое количество параметров к команде add")
            return false
        }
        when(parts[2])
        {
            "phone" -> return parts[3].matches(Regex("""[+]?\d+"""))
            "email" -> return parts[3].matches(Regex("""[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+"""))
            else -> {
                println("Мы пока умеем добавлять только телефон или email, но не ${parts[2]}")
                return false
            }
        }
    }

    fun run(){
        when(parts[2])
        {
            "phone" -> Person(name = parts[1], phone = parts[3])
            "email" -> Person(name = parts[1], email = parts[3])
        }
    }
}