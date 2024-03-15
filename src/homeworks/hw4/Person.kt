package homeworks.hw4

data class Person(val name: String, val phone: HashSet<String>, val email: HashSet<String>) {
    class EntryBuilder {
        private var name: String = ""
        private var phone: HashSet<String> = hashSetOf()
        private var email: HashSet<String> = hashSetOf()

        fun name(name: String): EntryBuilder {
            this.name = name
            return this
        }

        fun phone(phone: String): EntryBuilder {
            if(phone.isNotEmpty()) this.phone.add(phone)
            return this
        }

        fun email(email: String): EntryBuilder {
            if(email.isNotEmpty()) this.email.add(email)
            return this
        }

        fun build() = Person(name = name, phone = phone, email = email)
    }
}