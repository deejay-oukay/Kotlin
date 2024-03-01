package homeworks

/*
Написать программу, которая обрабатывает введённые пользователем в консоль команды:
exit
help
add <Имя> phone <Номер телефона>
add <Имя> email <Адрес электронной почты>

После выполнения команды, кроме команды exit, программа ждёт следующую команду.

Имя – любое слово.
Если введена команда с номером телефона, нужно проверить, что указанный телефон может начинаться с +, затем идут только цифры.
При соответствии введённого номера этому условию – выводим его на экран вместе с именем, используя строковый шаблон.
В противном случае - выводим сообщение об ошибке.
Для команды с электронной почтой делаем то же самое, но с другим шаблоном – для простоты, адрес должен содержать три последовательности букв, разделённых символами @ и точкой.
*/
fun main() {
    menu()
}

fun menu() {
    var command: String?
    do {
        println("""
Введите одну из команд:
exit
help
add <Имя> phone <Номер телефона>
add <Имя> email <Адрес электронной почты>
        
    """.trimIndent())
        command = readlnOrNull()
        if (command == "help")
            println("Никто тебе не поможет :-(\n")
        else if ((command != null) && command.contains("add"))
            println("${parseAdd(command)}\n")
        else
            println("Команда не распознана :-(\n")

    } while (command != "exit")
}

fun parseAdd(str: String): String {
    val parts = str.split(" ").toTypedArray()
    if (parts.size != 4)
        return "Недопустимое количество параметров к команде add"
    val result = when(parts[2])
    {
        "phone" -> parsePhone(parts[3])
        "email" -> parseEmail(parts[3])
        else -> return("Мы пока умеем добавлять только телефон или email, но не ${parts[2]}")
    }
    return if (result)
        "Успешно: ${parts[1]} ${parts[3]}"
    else
        "${parts[2]} имеет недопустимый формат"
}
fun parsePhone(str: String): Boolean {
    return str.matches(Regex("""[+]?\d+"""))
}

fun parseEmail(str: String): Boolean {
    return str.matches(Regex("""[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+"""))
}