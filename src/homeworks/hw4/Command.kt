package homeworks.hw4

sealed interface Command {
    companion object {
        val contacts: Contacts = ContactsImpl()
        val commands: HashMap<String, Command> = hashMapOf(
            "add" to AddCommand(),
            "AddPhone" to AddPhoneCommand(),
            "AddEmail" to AddEmailCommand(),
            "show" to ShowCommand(),
            "find" to FindCommand(),
            "help" to HelpCommand(),
            "exit" to ExitCommand())

        const val ARGUMENT_ERROR = "Argument error"
    }

    fun execute(data: String? = null)
    fun isValid(args: String?): Boolean
}