package homeworks.hw3

import seminars.s3.task2.calc

class Book {
    lateinit var persons: Set<Person>

    //Возвращает персону, которой нужно добавить другие данные
    fun addName(name: String): Person {
        val person = getByName(name)
        if (person != null)
                return(person)
        val newPerson: Person = Person(name)
        this.persons += newPerson
        return newPerson
    }
    fun addPhone(person: Person, phone: String) {
        person.addPhone(phone)
    }
    fun addEmail(person: Person, email: String) {
        person.addEmail(email)
    }

    fun getByName(name: String): Person? {
        for (person in persons)
            if (person.name == name)
                return(person)
        return null
    }

    fun findByPhoneOrEmail(data: String): Set<Person> {
        //СКОРЕЕ ВСЕГО ЗДЕСЬ НУЖНО ИСПЛЬЗОВАТЬ ФИЛЬТР, А НЕ ПРОСТОЙ ПРОХОД ПО ВСЕМ
//        for (person in persons)
//            if (person.phones.contains(data) || person.emails.contains(data))
//                println(person.toString())
        return persons.filter { it.phones.contains(data) || it.emails.contains(data) }

        return persons
    }
}