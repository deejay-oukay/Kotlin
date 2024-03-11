package homeworks.hw3

class Exit: Command {
    override fun isValid(): Boolean {
        return true
    }

    fun run(){
        println("Всего доброго...")
    }
}