package devintensive.skillbranch.ru.dev_intensive.models

import devintensive.skillbranch.ru.dev_intensive.utils.Utils
import java.util.*

data class User( //первичный конструктор
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnlain: Boolean = false
)
{
//    var introBit : String

    //вторичный конструктор
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this (id, "John", "Doe")

    //подблок, который будет вызван в любом случае (блок инициализации)
    init {
//        introBit = getIntro()

        println("It's Alive!!! \n${if(lastName==="Doe") "His name id $firstName $lastName"
                                        else "And his name is $firstName $lastName!!!" }\n"
//                                        + "${getIntro()}")
        )
    }

//    private fun getIntro() = """
//        tu tu tuttt
//        werw werwr werwe
//
//        werwr
//        werwerwe werwe werwer ....
//
//        $firstName $lastName
//    """.trimIndent()
//
//    //ничего не возвращает
//    fun printMe() = println("""
//            id: $id
//            firstName: $firstName
//            lastName: $lastName
//            avatar: $avatar
//            rating: $rating
//            respect: $respect
//            lastVisit: $lastVisit
//            isOnlain: $isOnlain
//        """.trimIndent())

    //к объект, функциии от которого могут использоваться в любой части кода
    companion object Factory{
        private var lastId : Int = -1

        fun makeUser(fullName:String?) : User{

            if(!fullName.isNullOrBlank()){
                lastId++

                //деструктуризация
                val (firstName, lastName) = Utils.parseFullName(fullName)

                return User(id = "$lastId", firstName = "$firstName", lastName = "$lastName")
            }
            else{
                return User(id = "$lastId", firstName = "Данных нет", lastName = "!")
            }
        }
    }


}