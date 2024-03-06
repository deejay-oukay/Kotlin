package homeworks.hw2

class Help: Command {
    override fun isValid(): Boolean {
        return true
    }

    fun run() {
        println("""Введите одну из команд:
help - Помощь
add <Имя> phone <Номер телефона>
add <Имя> email <Адрес электронной почты>
show - последние добавленные данные
exit - Выход
        """)
    }
}