package devintensive.skillbranch.ru.devintensive.extensions

import android.provider.ContactsContract
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

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
fun Date.humanizeDiff(date: Date = Date()): String? {
    val addDate = this

    var textData :String ?= null

//    val dif = if(addDate > date){
//        addDate.time - date.time
//    }else if(date > addDate){
//        date.time - addDate.time
//    }else addDate.time

    val date1 = date
    val date2 = addDate
    val calendar1 = Calendar.getInstance()
    val calendar2 = Calendar.getInstance()
    calendar1.time = date1
    calendar2.time = date2
    val milliseconds1 = calendar1.timeInMillis
    val milliseconds2 = calendar2.timeInMillis

    var diff: Long ?= null

    if(date1>date2){
        diff = milliseconds1 - milliseconds2
    }else{
        diff = milliseconds2 - milliseconds1
    }

    val diffSeconds = diff / 1000
    val diffMinutes = diff / (60 * 1000)
    val diffHours = diff / (60 * 60 * 1000)
    val diffDays = diff / (24 * 60 * 60 * 1000)

    if(diffSeconds >= 0 || diffSeconds <= 1){
        textData = "только что"
    }
    if(diffSeconds>=1 || diffSeconds<=45){
        textData = "несколько секунд назад"
    }
    if(diffSeconds<=45 && diffSeconds>=75){
        textData = "минуту назад"
    }


//    var second: Int ?= null
//    var minute: Int ?= null
//    var hour: Int ?= null
//    var day: Int ?= null
//

//
//    if(addDate >= date){
//        second = addDate.seconds - date.seconds
//        minute = addDate.minutes - date.minutes
//        hour = addDate.hours - date.hours
//        day = addDate.day - date.day
//    }else{
//        second = date.seconds - addDate.seconds
//        minute = date.minutes - addDate.minutes
//        hour = date.hours - addDate.hours
//        day = date.day - addDate.day
//    }
//
//    if(day == 0){
//        if(hour == 0){
//            if(minute == 0){
//                if(second >= 0 || second <= 1){
//                    textData = "только что"
//                }
//                else if(second>=1 || second<=45){
//                    textData = "несколько секунд назад"
//                }
//            }
//            else if(minute == 1){
//                if(second<=15 && second>=45){
//                    textData = "минуту назад"
//                }
//            }
//            else if(minute>1 || minute<=45){
//                textData = "$minute минут назад"
//            }
//        }
//        else if(hour == 1){
//            if(minute>=45 && minute<=15){
//                textData = "час назад"
//            }
//        }
//        else if(hour > 1 || hour <= 22){
//            textData = "$hour часов назад"
//        }
//    }
//    else if(day == 1){
//        if(hour >= 22 && hour<=2){
//            textData = "день назад"
//        }
//    }
//    else if(day > 1 || day <= 360){
//        textData = "$day дней назад"
//    }
//    else {
//        if(day > 360){
//            textData = "более года назад"
//        }
//    }



//    0с - 1с "только что"
//
//    1с - 45с "несколько секунд назад"
//
//    45с - 75с "минуту назад"
//
//    75с - 45мин "N минут назад"
//
//    45мин - 75мин "час назад"
//
//    75мин 22ч "N часов назад"
//
//    22ч - 26ч "день назад"
//
//    26ч - 360д "N дней назад"
//
//    >360д "более года назад"



    return textData//date.toString()
}

//класс перечеслений (жестко объявим какие единицы можно использовать в данной функции)
enum class TimeUnits{
    SECONDS, MINUTE, HOUR, DAY
}