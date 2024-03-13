package homeworks.hw3

class Help: Command {
    override fun isValid(): Boolean {
        return true
    }

    fun run() {
        println("""Введите одну из команд:
help - Помощь
add <Имя> phone <Номер телефона> - добавить телефон к имени
add <Имя> email <Адрес электронной почты> - добавить email к имени
show <Имя> - показать контактные данные по имени
find <Телефон или Email> - найти людей по контактным данным
exit - Выход
        """)
    }
}