package homeworks.hw2
import kotlin.reflect.*

data class Person (
    var name: String,
    var phone: String? = null,
    var email: String? = null
) {
    var lastCommand: String? = if (null != phone)
        "Имя: $name, Телефон: $phone"
    else if (null != email)
        "Имя: $name, Email: $email"
    else
        "Not initialized"
        get(){
            return if (field == null)
                "Not initialized"
            else
                field
        }

    fun last(): String? {
        return if (lastCommand == null)
            "Not initialized"
        else
            lastCommand
    }
}