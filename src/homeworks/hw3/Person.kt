package homeworks.hw3

data class Person (
    var name: String
) {
    var phones = mutableSetOf<String>()
    var emails = mutableSetOf<String>()

    fun addPhone(phone: String) {
        phones.add(phone)
        println("Данные персоны после добавления телефона: "+toString())
    }
    fun addEmail(email: String) {
        emails.add(email)
        println("Данные персоны после добавления почты: "+toString())
    }

    override fun toString(): String {
        return "Person(name='$name', phones=$phones, emails=$emails)"
    }
}

