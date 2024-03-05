package homeworks.hw2

class AddPhone(var phone: String): Command {
    override fun isValid(): Boolean {
        return phone.matches(Regex("""[+]?\d+"""))
    }
}