package homeworks.hw4

sealed interface Command {
    companion object {
        val contacts: Contacts = ContactsImpl()
        const val ARGUMENT_ERROR = "Argument error"
    }

    fun execute(data: String? = null)
    fun isValid(args: String?): Boolean
}