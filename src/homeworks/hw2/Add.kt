package homeworks.hw2

class Add(var command: String): Command {
    override fun isValid(): Boolean {
        val parts = command.split(" ").toTypedArray()
        if (parts.size != 4){
            println("Недопустимое количество параметров к команде add")
            return false
        }
        when(parts[2])
        {
            "phone" -> {
                if (AddPhone(parts[3]).isValid()) {
                    fun run(person: Person) {
                        person.addData(name = parts[1], phone = parts[3])
                    }
                    return true
                }
                else
                    return false
            }
            "email" -> {
                if (AddEmail(parts[3]).isValid()) {
                    fun run(person: Person) {
                        person.addData(name = parts[1], email = parts[3])
                    }
                    return true
                }
                else
                    return false
            }
            else -> {
                println("Мы пока умеем добавлять только телефон или email, но не ${parts[2]}")
                return false
            }
        }
    }
}