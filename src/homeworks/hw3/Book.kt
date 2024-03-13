package homeworks.hw3

class Book {
    private var persons = mutableSetOf<Person>()

    fun addPhoneToName(phone: String, name: String) {
        println("Пытаюсь добавить телефон $phone для $name")
        var person = getByName(name)
        if (person == null)
        {
            person = Person(name)
            println("Данные только что созданной персоны: $person")
            persons.add(person)
        }
        println("Список персон перед добавлением телефона: "+list())
        person.addPhone(phone)
        println("Список персон после добавления телефона: "+list())
    }
    fun addEmailToName(email: String, name: String) {
        var person = getByName(name)
        if (person == null)
        {
            person = Person(name)
            println("Данные только что созданной персоны: $person")
            persons.add(person)
        }
        println("Список персон перед добавлением почты: "+list())
        person.addEmail(email)
        println("Список персон после добавления почты: "+list())
    }

    fun getByName(name: String): Person? {
        println("Пытаюсь найти по имени $name")
        if (persons.isNotEmpty())
        {
            for (person in persons)
                if (person.name == name)
                    return(person)
            println("Не найдено")
        }
        else
            println("Список пока пустой")
        return null
    }

    fun findByPhoneOrEmail(data: String): MutableSet<out Any> {
        println("Пытаюсь найти телефон или почту $data")
        if (persons.isNotEmpty())
            return mutableSetOf(persons.filter { it.phones.contains(data) || it.emails.contains(data) })
        else
            println("Список пока пустой")
        return mutableSetOf<Person>()
    }

    private fun list(): String {
        var result = ""
        for (person in persons)
            result += "\n$person"
        return "$result\n"
    }
}