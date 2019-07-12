package devintensive.skillbranch.ru.devintensive.utils

object Utils {

    //разбиение одной строки на несколько
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        if (firstName.isNullOrBlank()) firstName = null
        if (lastName.isNullOrBlank()) lastName = null

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var newPayload: String = payload

        newPayload = newPayload.replace(" ", divider)

        newPayload = newPayload.replace("а", "a")
        newPayload = newPayload.replace("б", "b")
        newPayload = newPayload.replace("в", "v")
        newPayload = newPayload.replace("г", "g")
        newPayload = newPayload.replace("д", "d")
        newPayload = newPayload.replace("е", "e")
        newPayload = newPayload.replace("ё", "e")
        newPayload = newPayload.replace("ж", "zh")
        newPayload = newPayload.replace("з", "z")
        newPayload = newPayload.replace("и", "i")
        newPayload = newPayload.replace("й", "i")
        newPayload = newPayload.replace("к", "k")
        newPayload = newPayload.replace("л", "l")
        newPayload = newPayload.replace("м", "m")
        newPayload = newPayload.replace("н", "n")
        newPayload = newPayload.replace("о", "o")
        newPayload = newPayload.replace("п", "p")
        newPayload = newPayload.replace("р", "r")
        newPayload = newPayload.replace("с", "s")
        newPayload = newPayload.replace("т", "t")
        newPayload = newPayload.replace("у", "u")
        newPayload = newPayload.replace("ф", "f")
        newPayload = newPayload.replace("х", "h")
        newPayload = newPayload.replace("ц", "c")
        newPayload = newPayload.replace("ч", "ch")
        newPayload = newPayload.replace("ш", "sh")
        newPayload = newPayload.replace("щ", "sh")
        newPayload = newPayload.replace("ъ", "")
        newPayload = newPayload.replace("ы", "i")
        newPayload = newPayload.replace("ь", "")
        newPayload = newPayload.replace("э", "e")
        newPayload = newPayload.replace("ю", "yu")
        newPayload = newPayload.replace("я", "ya")

        newPayload = newPayload.replace("А", "A")
        newPayload = newPayload.replace("б", "B")
        newPayload = newPayload.replace("в", "V")
        newPayload = newPayload.replace("г", "G")
        newPayload = newPayload.replace("д", "D")
        newPayload = newPayload.replace("е", "E")
        newPayload = newPayload.replace("Ж", "Zh")
        newPayload = newPayload.replace("З", "Z")
        newPayload = newPayload.replace("И", "I")
        newPayload = newPayload.replace("Й", "I")
        newPayload = newPayload.replace("К", "K")
        newPayload = newPayload.replace("Л", "L")
        newPayload = newPayload.replace("М", "M")
        newPayload = newPayload.replace("Н", "N")
        newPayload = newPayload.replace("О", "O")
        newPayload = newPayload.replace("П", "P")
        newPayload = newPayload.replace("Р", "R")
        newPayload = newPayload.replace("С", "S")
        newPayload = newPayload.replace("Т", "T")
        newPayload = newPayload.replace("У", "U")
        newPayload = newPayload.replace("Ф", "F")
        newPayload = newPayload.replace("Х", "H")
        newPayload = newPayload.replace("Ц", "C")
        newPayload = newPayload.replace("Ч", "Ch")
        newPayload = newPayload.replace("Ш", "Sh")
        newPayload = newPayload.replace("Щ", "Sh")
        newPayload = newPayload.replace("Ъ", "")
        newPayload = newPayload.replace("Ы", "I")
        newPayload = newPayload.replace("Ь", "")
        newPayload = newPayload.replace("Э", "E")
        newPayload = newPayload.replace("Ю", "Yu")
        newPayload = newPayload.replace("Я", "Ya")

        return newPayload
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        var oneFirstName: String? = ""
        var oneLastName: String? = ""
        var inicial: String? = ""

        if (!firstName.isNullOrBlank() && firstName != "null") {
            oneFirstName = firstName.get(0).toString()//replaseInitials(firstName.get(0).toString())
        } else oneFirstName = ""

        if (!lastName.isNullOrBlank() && lastName != "null") {
            oneLastName = lastName.get(0).toString()//replaseInitials(lastName.get(0).toString())
        } else oneLastName = ""

        if (firstName.isNullOrBlank() && lastName.isNullOrBlank())
            inicial = null
        else
            inicial = oneFirstName + oneLastName

        return inicial
    }

    fun replaseInitials(simbol: String): String {
        var simbolExit: String? = ""
        when (simbol) {
            "а" -> simbolExit = "a"
            "б" -> simbolExit = "b"
            "в" -> simbolExit = "v"
            "г" -> simbolExit = "g"
            "д" -> simbolExit = "d"
            "е" -> simbolExit = "e"
            "ё" -> simbolExit = "e"
            "ж" -> simbolExit = "zh"
            "з" -> simbolExit = "z"
            "и" -> simbolExit = "i"
            "й" -> simbolExit = "i"
            "к" -> simbolExit = "k"
            "л" -> simbolExit = "l"
            "м" -> simbolExit = "m"
            "н" -> simbolExit = "n"
            "о" -> simbolExit = "o"
            "п" -> simbolExit = "p"
            "р" -> simbolExit = "r"
            "с" -> simbolExit = "s"
            "т" -> simbolExit = "t"
            "у" -> simbolExit = "u"
            "ф" -> simbolExit = "f"
            "х" -> simbolExit = "h"
            "ц" -> simbolExit = "c"
            "ч" -> simbolExit = "ch"
            "ш" -> simbolExit = "sh"
            "щ" -> simbolExit = "sh'"
            "ъ" -> simbolExit = ""
            "ы" -> simbolExit = "i"
            "ь" -> simbolExit = ""
            "э" -> simbolExit = "e"
            "ю" -> simbolExit = "yu"
            "я" -> simbolExit = "ya"
            else -> simbolExit = simbol
        }
        return simbolExit
    }
}