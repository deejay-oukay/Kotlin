package homeworks.hw4

import java.io.File
import java.io.FileNotFoundException

class Export: Command {
    override fun isValid(args: String?) = !args.isNullOrEmpty()

    override fun execute(data: String?) {
        if (Command.contacts.isEmpty()) {
            println("Список пуст")
            return
        }

        getExportData().run {
            try {
                FileUtils.writeText(data!!, this.toString())
                println("Экспорт завершён")
            } catch (e: FileNotFoundException) {
                println("Ошибка при записи данных в файл")
            }
        }
    }

    private fun getExportData() = json {
        jsonList {
            Command.contacts.findAll().forEach {
                jsonObj {
                    p("name" to it.name)
                    p("phones" to it.phones)
                    p("emails" to it.emails)
                }
            }
        }
    }
}

class Json {
    private val list = JsonList()
    fun jsonList(callback: JsonList.() -> Unit) = list.callback()
    override fun toString() = "$list"
}

fun json(callback: Json.() -> Unit): Json {
    val builder = Json()
    builder.callback()
    return builder
}

class JsonList {
    private val children = mutableListOf<Any>()
    fun jsonObj(callback: JsonObject.() -> Unit) = children.add(JsonObject().apply(callback))
    override fun toString() = "[${children.joinToString(",")}]"
}

class JsonObject {
    private val children = hashMapOf<String, Any>()

    infix fun JsonObject.p(property: Pair<String, Any>) {
        this.children[property.first] = when (property.second) {
            is HashSet<*> -> "[${(property.second as HashSet<*>).joinToString(",") { "\"${it}\"" }}]"
            is String -> "\"${property.second}\""
            else -> property.second
        }
    }

    override fun toString()= "{${children.entries.joinToString(",") { "\"${it.key}\": ${it.value}" }}}"
}

object FileUtils {
    @JvmStatic
    fun writeText(file: String, text: String) = File(file).writeText(text)
}