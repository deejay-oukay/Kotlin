package homeworks.hw2

data class Person (
    var name: String,
    var phone: String? = null,
    var email: String? = null
) {
    var lastCommand = if (null != phone)
        "Имя: $name, Телефон: $phone"
    else if (null != email)
        "Имя: $name, Email: $email"
    else
        "Not initialized"
}