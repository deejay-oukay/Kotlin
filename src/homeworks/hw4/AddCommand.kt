package homeworks.hw4

class AddCommand: Command {
    private var args = HashMap<String, String>()
    private val parser = Parser()

    override fun isValid(data: String?): Boolean {
        if(data.isNullOrEmpty() || data.trim().isEmpty())
            return false
        return try {
            parser.parse(data)
            true
        } catch (e: ArgumentErrorException) {
            false
        }
    }
    private inner class Parser {
        val argsForValidate = hashSetOf< Triple<String, Exception, (String) -> Boolean> > (
            Triple("phone", Exception("Некорректный номер телефона")) { Validator.isPhoneNumberValid(it) },
            Triple("email", Exception("Некорректный адрес почты")) { Validator.isEmailValid(it) }
        )

        fun parse(data: String) {
            args.clear()
            val items = data.trim().split(" ")

            if (items.isEmpty() || items.size > argsForValidate.size + 3)
                throw Exception("Некорретное количество элементов при добавлении данных")
            if (argsForValidate.any { it.first == items[0] })
                throw ArgumentErrorException(Command.ARGUMENT_ERROR)
            if (items.first().isEmpty())
                throw Exception("Имя не указано")
            if(items.drop(1).count() % 2 != 0)
                throw ArgumentErrorException(Command.ARGUMENT_ERROR)
            args["name"] = items.first()
            items.drop(1)
                .chunked(2)
                .forEach {
                    if(argsForValidate.none { arg -> arg.first == it[0] } || args.contains(it[0])) {
                        throw ArgumentErrorException(Command.ARGUMENT_ERROR)
                    } else {
                        if(argsForValidate.first { arg -> arg.first == it[0] }.third(it[1])) {
                            args[it[0]] = it[1]
                        } else throw argsForValidate.first { arg -> arg.first == it[0] }.second
                    }
                }
        }
    }
    override fun execute(data: String?) {
        if(args.isEmpty())
            parser.parse(data.toString())
        with(
            Person.EntryBuilder()
                .name(args["name"] ?: throw Exception("Некорректное имя"))
                .phone(args["phone"] ?: "")
                .email(args["email"] ?: "")
                .build()
        ) {
            if (Command.contacts.isPersonExists(this))
                Command.contacts.update(this)
            else
                Command.contacts.add(this)
            println("Результат: "+Command.contacts.findPersonByName(this.name).toString())
        }
    }


}