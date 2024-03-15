package homeworks.hw4

class CommandParserImpl: CommandParser {
    companion object {
        const val COMMAND_ERROR = "Некорректная компанда"
    }

    override fun readCommand(data: String?): Pair<Command, String?> {
        if(data.isNullOrEmpty() || data.trim().isEmpty()) {throw CommandErrorException(COMMAND_ERROR)}
        val items = data.split(" ")
        val command = Command.commands[items.first()] ?: throw CommandErrorException(COMMAND_ERROR)
        val args = items.subList(1, items.size).joinToString(" ")

        return Pair(command, args)
    }
}