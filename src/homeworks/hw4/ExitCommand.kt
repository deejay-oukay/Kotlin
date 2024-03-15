package homeworks.hw4

import kotlin.system.exitProcess

class ExitCommand: Command {
    override fun isValid(args: String?) = args.isNullOrEmpty()
    override fun execute(data: String?) {
        println("Всего доброго...")
        exitProcess(-1)
    }
}