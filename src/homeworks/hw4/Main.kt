package homeworks.hw4

/*
Продолжаем дорабатывать домашнее задание из предыдущего семинара. За основу берём код решения из предыдущего домашнего задания.

— Добавьте новую команду export, которая экспортирует добавленные значения в текстовый файл в формате JSON.
  Команда принимает путь к новому файлу. Например export /Users/user/myfile.json
— Реализуйте DSL на Kotlin, который позволит конструировать JSON и преобразовывать его в строку.
— Используйте этот DSL для экспорта данных в файл.
— Выходной JSON не обязательно должен быть отформатирован, поля объектов могут идти в любом порядке.
  Главное, чтобы он имел корректный синтаксис. Такой вывод тоже принимается:
  [{""emails"": [""ew@huh.ru""],""name"": ""Alex"",""phones"": [""34355"",""847564""]},{""emails"": [],""name"": ""Tom"",""phones"": [""84755""]}]

Записать текст в файл можно при помощи удобной функции-расширения writeText:
File(""/Users/user/file.txt"").writeText(""Text to write"")

Под капотом она использует такую конструкцию
FileOutputStream(file).use {it.write(text.toByteArray(Charsets.UTF_8))}
*/

fun readCommand(data: String?): Pair<Command, String?>? {
    if (data.isNullOrEmpty() || data.trim().isEmpty()) {
        HelpCommand().execute()
        return null
    }
    val items = data.split(" ")
    val args = items.subList(1, items.size).joinToString(" ")

    return Pair(when (items.first()) {
        "add" -> AddCommand()
        "show" -> ShowCommand()
        "find" -> FindCommand()
        "exit" -> ExitCommand()
        else -> HelpCommand()
    },args)
}
fun main() {
    HelpCommand().execute()
    while (true)
        readCommand(readlnOrNull())?.run {
            if (!first.isValid(second))
                HelpCommand().execute("Команда введена некорректно")
            else
                try {
                    first.execute(second)
                } catch (e: Exception) {
                    HelpCommand().execute(e.message)
                }
        }
}