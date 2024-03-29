package homeworks.hw4

class Show: Command {
    override fun execute(name: String?) {
        if (!name.isNullOrEmpty() && name.trim().isNotEmpty())
            with (Command.contacts.findPersonByName(name.trim())) {
                println(this?.toString() ?: "Не найдено")
            }
    }

    override fun isValid(args: String?) = !args.isNullOrEmpty()
}