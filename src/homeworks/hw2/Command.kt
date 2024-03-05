package homeworks.hw2

sealed interface Command {
    fun isValid(): Boolean
}

