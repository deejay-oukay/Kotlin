package seminars.s3.task1

//Задание №1 “Дописать функцию-расширение”
//Дана функция main
fun main() {
    /*
     * При помощи стандартных функций-расширений для работы с коллекциями вывести на экран:
	 * Количество людей в городе London в возрасте от 21 до 30 лет включительно.
	 * Список имён без повторений для города Berlin.
	 * Список городов, в которых есть хотя бы один человек по имени Oliver.
	 */

    val countLondonPeolple = entries
        .filter { it.city == "London" && it.age in 21..30 }
        .count()
    println("Людей в Лондоне $countLondonPeolple")

    val nameOfBerlin = entries
        .filter { it.city == "Berlin" }
        .map { it.name }
        .distinct()
    println("Имена в Берлине $nameOfBerlin")

    val cityWithOliver = entries
        .filter { it.name == "Oliver" }
        .map { it.city }
        .distinct()
    println("Города с Оливером $cityWithOliver")
}

data class Entry(
    val city: String,
    val name: String,
    val age: Int
)

val entries = listOf(
    Entry("London", "Liam", 28),
    Entry("Berlin", "Oliver", 24),
    Entry("Madrid", "Oliver", 45),
    Entry("Berlin", "Jerry", 29),
    Entry("London", "Oliver", 19),
    Entry("Madrid", "Kate", 16),
    Entry("Berlin", "Oliver", 34),
    Entry("London", "Kate", 25),
    Entry("Berlin", "Oliver", 23),
    Entry("Milan", "Jerry", 28),
    Entry("Paris", "Charles", 44)
)

