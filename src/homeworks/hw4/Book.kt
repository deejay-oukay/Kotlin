package homeworks.hw4

class Book {
    private val persons = hashSetOf<Person>()

    fun add(person: Person) = persons.add(person)

    fun findPersonByName(name: String) = persons.firstOrNull { it.name == name }

    fun update(person: Person) {
        findPersonByName(person.name)?.let{
            it.email.addAll(person.email)
            it.phone.addAll(person.phone)
        }
    }

    fun isPersonExists(person: Person) = findPersonByName(person.name) != null

    fun findPeopleByPhoneOrEmail(data: String) = persons.filter { it.phone.contains(data) || it.email.contains(data)}.toHashSet()

    fun findAll() = persons.map { it.value }.toHashSet()

    fun isEmpty() = persons.isEmpty()
}