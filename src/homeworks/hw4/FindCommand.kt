package homeworks.hw4

class FindCommand: Command {
    private val parser = Parser()
    companion object {
        const val NOTHING_FOUND = "Nothing found"
        val subCommands: List<(String) -> HashSet<Person>> = listOf(
            { Command.contacts.findPeopleByPhone(it) },
            { Command.contacts.findPeopleByEmail(it) })
    }

    override fun isValid(args: String?) = !args.isNullOrEmpty()

    override fun execute(data: String?) {
        if(data.isNullOrEmpty() || data.trim().isEmpty())
            throw ArgumentErrorException(Command.ARGUMENT_ERROR)
        parser.getCommand(data).also {
            if (it == null) {
                println("Не найдено")
                return
            }

            val (executor, value) = it
            val people = executor(value)
            println(if(people.isNotEmpty()) people.toString() else throw Exception("Список контактов - пуст"))
        }
    }

    private inner class Parser {
        fun getCommand(data: String) =  when {
            Validator.isPhoneNumberValid(data) -> subCommands[0] to data
            Validator.isEmailValid(data) -> subCommands[1] to data
            else -> null
        }
    }
}