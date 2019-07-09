package devintensive.skillbranch.ru.dev_intensive.utils

object Utils {

    //разбиение одной строки на несколько
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        val parts : List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        if (firstName.isNullOrBlank()) firstName = null
        if (lastName.isNullOrBlank()) lastName = null

        return firstName to lastName
    }

    fun transliteration(payload: String, divider:String = " "): String {

            payload.replace("а", "a")
            payload.replace("б", "b")
            payload.replace("в", "v")
            payload.replace("г", "g")
            payload.replace("д", "d")
            payload.replace("е", "e")
            payload.replace("ё", "e")
            payload.replace("ж", "zh")
            payload.replace("з", "z")
            payload.replace("и", "i")
            payload.replace("й", "i")
            payload.replace("к", "k")
            payload.replace("л", "l")
            payload.replace("м", "m")
            payload.replace("н", "n")
            payload.replace("о", "o")
            payload.replace("п", "p")
            payload.replace("р", "r")
            payload.replace("с", "s")
            payload.replace("т", "t")
            payload.replace("у", "u")
            payload.replace("ф", "f")
            payload.replace("х", "h")
            payload.replace("ц", "c")
            payload.replace("ч", "ch")
            payload.replace("ш", "sh")
            payload.replace("щ", "sh")
            payload.replace("ъ", "")
            payload.replace("ы", "i")
            payload.replace("ь", "")
            payload.replace("э", "e")
            payload.replace("ю", "yu")
            payload.replace("я", "ya")

        return payload
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        var oneFirstName:String ?= ""
        var oneLastName:String ?= ""
        var inicial:String ?= ""

        if(!firstName.isNullOrBlank() && firstName != "null"){
            oneFirstName = firstName.get(0).toString()//replaseInitials(firstName.get(0).toString())
        }
        else oneFirstName = ""

        if(!lastName.isNullOrBlank() && lastName != "null"){
            oneLastName = lastName.get(0).toString()//replaseInitials(lastName.get(0).toString())
        }
        else oneLastName = ""

        if(firstName.isNullOrBlank() && lastName.isNullOrBlank())
            inicial = null
        else
            inicial = oneFirstName + oneLastName

        return inicial
    }

    fun replaseInitials(simbol:String):String{
        var simbolExit : String ?= ""
        when(simbol) {
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