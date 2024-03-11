package homeworks.hw3

//Продолжаем дорабатывать домашнее задание из предыдущего семинара. За основу берём код решения из предыдущего домашнего задания.
//— Измените класс Person так, чтобы он содержал список телефонов и список почтовых адресов, связанных с человеком.
//— Теперь в телефонной книге могут храниться записи о нескольких людях. Используйте для этого наиболее подходящую структуру данных.
//— Команда AddPhone теперь должна добавлять новый телефон к записи соответствующего человека.
//— Команда AddEmail теперь должна добавлять новый email к записи соответствующего человека.
//— Команда show должна принимать в качестве аргумента имя человека и выводить связанные с ним телефоны и адреса электронной почты.
//— Добавьте команду find, которая принимает email или телефон и выводит список людей, для которых записано такое значение.

fun readCommand(command: String?): Command {
    return when(command) {
        "help" -> Help()
        "show" -> Show()
        "exit" -> Exit()
        else -> {
            if ((command !== null) && command.contains("add")) {
                Add(command)
            } else {
                Help()
            }
        }
    }
}

fun main() {
    Help().run()
    do {
        val command = readlnOrNull()
        val test = readCommand(command)
        println(test)
        if ((null != command) && test.isValid()) {
            when(test){
                is Help -> Help().run()
                is Add -> Add(command).run()
                is Show -> Show().run()
                else -> Exit().run()
            }
        } else
            Help().run()
    } while (test !is Exit)
}

