package homeworks.hw4

object Validator {
    const val PHONE_NUMBER_ERROR = "Phone number error"
    const val EMAIL_ERROR = "Email error"
    @JvmStatic
    fun isPhoneNumberValid(phoneNumber: String) = phoneNumber.matches(Regex("""[+]?\d+"""))

    @JvmStatic
    fun isEmailValid(email: String) = email.matches(Regex("""[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+"""))
}