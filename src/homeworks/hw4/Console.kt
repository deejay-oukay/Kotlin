package homeworks.hw4

class Console: UserInterface {
    override fun input(): String? = print("> ").run { readlnOrNull() }
    override fun output(data: String) = println(data)
}