package homeworks.hw3

sealed interface Command {
    fun isValid(): Boolean
}
