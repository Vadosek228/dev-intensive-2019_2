package devintensive.skillbranch.ru.dev_intensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String{
    val dateFormat =
        when(pattern) {
            "HH:mm" -> SimpleDateFormat("HH:mm", Locale("ru"))
            else -> SimpleDateFormat(pattern, Locale("ru"))
        }

    return dateFormat.format(this)
}

//разбиение даты на несколько строк
fun Date.stroke(pattern: String?):Pair<String?, String?>{

    val formatPattern : List<String>? = pattern?.split(" ")

    var fullTime = formatPattern?.getOrNull(0)
    var lastTime = formatPattern?.getOrNull(1)

    if (fullTime.isNullOrBlank()) fullTime = ""
    if (lastTime.isNullOrBlank()) lastTime = ""

    return fullTime to lastTime
}

//позволяет добовлять к объекту дату, которая будет изменить сдвиг
fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECONDS) : Date{ //по умолчанию - секунды
    var time = this.time

    time += when(units){ //принимает единицу измерения
        TimeUnits.SECONDS -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    this.time = time

    return this
}

//преобразовывает как расширение дату для пользователя
fun Date.humanizeDiff(date: Date = Date()): String {
    //TODO("REASDAS")

    var textData : String ?= ""

    when(date){

    }

    return date.toString()
}

//класс перечеслений (жестко объявим какие единицы можно использовать в данной функции)
enum class TimeUnits{
    SECONDS, MINUTE, HOUR, DAY
}