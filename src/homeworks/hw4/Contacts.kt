package homeworks.hw4

interface Contacts {
    fun add(person: Person): Boolean
    fun findPersonByName(name: String): Person?
    fun isPersonExists(person: Person): Boolean
    fun update(person: Person)
    fun findPeopleByEmail(email: String): HashSet<Person>
    fun findPeopleByPhone(phone: String): HashSet<Person>
}