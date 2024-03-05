package homeworks.hw2

class Help: Command {
    override fun isValid(): Boolean {
        return false
    }
    fun run() {
        println("""
Введите одну из команд:
exit
help
add <Имя> phone <Номер телефона>
add <Имя> email <Адрес электронной почты>
        """)
    }
}