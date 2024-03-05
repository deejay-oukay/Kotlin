package homeworks.hw2

class Exit: Command {
    override fun isValid(): Boolean {
        return true
    }

    fun run(){
        println("Всего доброго...")
    }
}