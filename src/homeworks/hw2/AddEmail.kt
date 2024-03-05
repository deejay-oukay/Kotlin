package homeworks.hw2

class AddEmail(var email: String): Command {
    override fun isValid(): Boolean {
        return email.matches(Regex("""[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+"""))
    }
}