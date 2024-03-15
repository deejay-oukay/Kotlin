package homeworks.hw4

class ShowCommand: Command {
    companion object {
        const val PERSON_NOT_FOUND = "Person not found"
    }
    override fun execute(name: String?) {
        if(name.isNullOrEmpty() || name.trim().isEmpty())
            throw ArgumentErrorException(Command.ARGUMENT_ERROR)

        with (Command.contacts.findPersonByName(name.trim())) {
            println(this?.toString() ?: "Не найдено")
        }
    }

    override fun isValid(args: String?) = !args.isNullOrEmpty()
}