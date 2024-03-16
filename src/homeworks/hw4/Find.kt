package homeworks.hw4

class Find: Command {
    override fun isValid(args: String?) = !args.isNullOrEmpty()

    override fun execute(data: String?) {
        if(data.isNullOrEmpty() || data.trim().isEmpty())
        {
            Help().execute("Не указаны контактные данные для поиска")
            return
        }
        val results = Command.contacts.findPeopleByPhoneOrEmail(data)
        println(
            if(results.isNotEmpty())
                results.toString()
            else
                "Не найдено"
        )
    }
}