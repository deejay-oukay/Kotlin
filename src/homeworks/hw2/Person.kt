package homeworks.hw2

data class Person (
    var name: String,
    var phone: String?,
    var email: String?,
    var lastCommand: String? = "Not initialized"
) {
    fun addData(name: String, phone: String? = null, email: String? = null){
        this.name = name
        this.phone = phone
        this.email = email
        if (phone != null)
            lastCommand = "Имя: $name, Телефон: $phone"
        else if (email != null)
            lastCommand = "Имя: $name, Email: $email"
        else
            lastCommand = "Not initialized"
    }
}