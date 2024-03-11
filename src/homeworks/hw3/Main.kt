package homeworks.hw3

//Продолжаем дорабатывать домашнее задание из предыдущего семинара. За основу берём код решения из предыдущего домашнего задания.
//— Измените класс Person так, чтобы он содержал список телефонов и список почтовых адресов, связанных с человеком.
//— Теперь в телефонной книге могут храниться записи о нескольких людях. Используйте для этого наиболее подходящую структуру данных.
//— Команда AddPhone теперь должна добавлять новый телефон к записи соответствующего человека.
//— Команда AddEmail теперь должна добавлять новый email к записи соответствующего человека.
//— Команда show должна принимать в качестве аргумента имя человека и выводить связанные с ним телефоны и адреса электронной почты.
//— Добавьте команду find, которая принимает email или телефон и выводит список людей, для которых записано такое значение.

fun readCommand(command: String): Command {
    return when(command) {
        "help" -> Help()
        "show" -> Show(command)
        "find" -> Find(command)
        "exit" -> Exit()
        else -> {
            if (command.contains("add")) {
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
        val command = readln()
        val test = readCommand(command)
        if (test.isValid()) {
            when(test){
                is Help -> Help().run()
                is Add -> Add(command).run()
                is Show -> Show(command).run()
                is Find -> Find(command).run()
                else -> Exit().run()
            }
        } else
            Help().run()
    } while (test !is Exit)
}

