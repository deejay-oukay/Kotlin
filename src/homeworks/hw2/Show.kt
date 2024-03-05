package homeworks.hw2

class Show(): Command {
    override fun isValid(): Boolean {
        return true
    }

    fun run() {
        fun run(person: Person) {
            println(person.lastCommand)
        }
    }
}