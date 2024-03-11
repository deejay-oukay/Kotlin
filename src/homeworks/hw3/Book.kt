package homeworks.hw3

class Book {
    private lateinit var persons: Set<Person>

    //Возвращает персону, которой нужно добавить другие данные
    fun addName(name: String): Person {
        if (persons.isNotEmpty())
        {
            val person = getByName(name)
            if (person != null)
            {
                println("Имя $name найдено")
                return(person)
            }
        }
        println("Имя $name НЕ найдено")
        val newPerson = Person(name)
        this.persons = this.persons.plus(newPerson)
        return newPerson
    }
    fun addPhone(person: Person, phone: String) {
        println("Пытаюсь добавить телефон $phone")
        person.addPhone(phone)
    }
    fun addEmail(person: Person, email: String) {
        println("Пытаюсь добавить email $email")
        person.addEmail(email)
    }

    fun getByName(name: String): Person? {
        println("Пытаюсь найти по имени $name")
        if (persons.isNotEmpty())
            for (person in persons)
                if (person.name == name)
                    return(person)
        return null
    }

    fun findByPhoneOrEmail(data: String): List<Person> {
        return persons.filter { it.phones.contains(data) || it.emails.contains(data) }
    }
}