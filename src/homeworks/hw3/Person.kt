package homeworks.hw3
import kotlin.reflect.*

data class Person (
    var name: String
) {
    lateinit var phones: Set<String>
    lateinit var emails: Set<String>

    fun addPhone(phone: String) {
        phones += phone
    }
    fun addEmail(email: String) {
        emails += email
    }

    override fun toString(): String {
        return "Person(name='$name', phones=$phones, emails=$emails)"
    }


}