package homeworks.hw4

interface CommandParser {
    fun readCommand(data: String?): Pair<Command, String?>
}