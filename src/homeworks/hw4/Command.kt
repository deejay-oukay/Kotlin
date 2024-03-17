package homeworks.hw4

sealed interface Command {
    companion object {
        val contacts: Book = Book()
    }

    fun execute(data: String? = null)
    fun isValid(args: String?): Boolean
}