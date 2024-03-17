package homeworks.hw4

class Add: Command {
    private var args = HashMap<String, String>()
    private val parser = Parser()

    override fun isValid(data: String?): Boolean {
        if(data.isNullOrEmpty() || data.trim().isEmpty())
            return false
        parser.parse(data)
        return true
    }
    private inner class Parser {
        fun parse(data: String) {
            args.clear()
            val items = data.trim().split(" ")
            if (items.isNotEmpty() && items.size == 3)
            {
                args["name"] = items.first()
                when (items[1]){
                    "phone" -> if (isPhoneValid(items[2])) args["phone"] = items[2]
                    "email" -> if (isEmailValid(items[2])) args["email"] = items[2]
                    else -> println("Мы пока умеем добавлять только телефон или email, но не ${items[2]}")
                }
            }
        }
    }
    override fun execute(data: String?) {
        if(args.isEmpty())
            parser.parse(data.toString())
        if ((args["name"] != null) && ((args["phone"] != null) || (args["email"] != null)))
        {
            with(
                Person.EntryBuilder()
                    .name(args["name"] ?: "")
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
        else
            Help().execute("Некорретно указаны обязательные для заполнения данные")
    }

    fun isPhoneValid(phone: String) = phone.matches(Regex("""[+]?\d+"""))

    fun isEmailValid(email: String) = email.matches(Regex("""[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+"""))

}