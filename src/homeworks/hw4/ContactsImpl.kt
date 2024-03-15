package homeworks.hw4

class ContactsImpl: Contacts {

    private val people = hashSetOf<Person>()

    override fun add(person: Person) = people.add(person)

    override fun findPersonByName(name: String) = people.firstOrNull { it.name == name }

    override fun update(person: Person) {
        findPersonByName(person.name)?.let{
            it.email.addAll(person.email)
            it.phone.addAll(person.phone)
        }
    }

    override fun isPersonExists(person: Person)= findPersonByName(person.name) != null

    override fun findPeopleByEmail(email: String) = people.filter { it.email.contains(email) }.toHashSet()

    override fun findPeopleByPhone(phone: String) = people.filter { it.phone.contains(phone) }.toHashSet()
}