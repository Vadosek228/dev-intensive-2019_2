package devintensive.skillbranch.ru.dev_intensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        //TODO FIX ME!!!
        val parts : List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun transliteration(payload: String, divider:String = " "): String {
        //TODO
        return payload
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return firstName
    }
}