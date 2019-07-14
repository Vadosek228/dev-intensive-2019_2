package devintensive.skillbranch.ru.devintensive

import devintensive.skillbranch.ru.devintensive.extensions.*
import devintensive.skillbranch.ru.devintensive.models.*
import devintensive.skillbranch.ru.devintensive.utils.Utils
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    //тест на создание объектов пользователя
    @Test
    fun test_instance() {
        val user = User("1")
        val user2 = User("2", "John", "Wick")
        val user3 = User("3", "John", "Silverhand", null, lastVisit = Date(), isOnlain = true)
    }

    //как работает фабрика
    @Test
    fun test_factory(){
        val user = User.makeUser("John Seen")
        val user2 = User.makeUser("John Weck")
        val user3 = User.makeUser("")
        val user4 = user2.copy(id = "2", lastName = "Gav")
        val user5 = User.makeUser(null)
        val user6 = User.makeUser("John")
        val user7 = User.makeUser(" ")

        print("$user2 \n$user4")
    }

    @Test
    fun test_decomposition(){
        val user = User.makeUser("John Weck")

        //возвращает информацию о пользователе
        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")

        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
    }

    @Test
    fun test_copy(){
        val user = User.makeUser("John Weck")
        val user2 = user.copy(id = "2", lastVisit = Date().add(-2,TimeUnits.SECONDS))
        val user3 = user.copy(lastName = "Ceva", lastVisit = Date().add(2, TimeUnits.HOUR))

        //если значение первого пользователя соответствуют значениям второго пользователя
        if(user.equals(user2)){ //сравнить объекты ==
            println("equels data and hash\n${user.hashCode()} $user \n${user2.hashCode()} $user2")
        } else {
            println("not equels data and hash\n${user.hashCode()} $user \n${user2.hashCode()} $user2")
        }

        //сравить ссылки
        if(user === user2){
            println("equels address \n" +
                    "${System.identityHashCode(user)} \n" +
                    "${System.identityHashCode(user2)}")
        } else {
            println("not equels address \n" +
                    "${System.identityHashCode(user)} \n" +
                    "${System.identityHashCode(user2)}")
        }


        println("""
            ${user.lastVisit}
            ${user2.lastVisit?.format("HH.mm")}
            ${user3.lastVisit?.format()}
        """.trimIndent())
    }

    @Test
    fun test_dataq_maping(){
        val user = User.makeUser("Акулинин Владислав")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.HOUR))

        print(newUser)

        val userView = newUser.toUserView()

        userView.printMe()
    }

    @Test
    fun test_abstract_factory(){
        val user = User.makeUser("Акулинин Владислав")
        val user2 = User.makeUser("Владислав")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), date = Date(), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user2, Chat("0"), date = Date(), payload = "https://anyurl.com", type = "image")

        println(txtMessage.formateMessage())
        println(imgMessage.formateMessage())
    }

    @Test
    fun toInitials(){

        val user1 = Utils.toInitials("акулинин" ,"владислав") //JD
        val user2 = Utils.toInitials("John", null) //J
        val user3 = Utils.toInitials(null, null) //null
        val user4 = Utils.toInitials(" ", "") //null

        println(user1)
        println(user2)
        println(user3)
        println(user4)

    }

    @Test
    fun transliteration(){
        val user1 = Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
        val user2 = Utils.transliteration("Amazing Петр","_") //Amazing_Petr

        println(user1)
        println(user2)
    }

    @Test
    fun humanizeDiff(){
        val user1 = Date().add(1, TimeUnits.SECONDS).humanizeDiff() //2 часа назад
        val user2 = Date().add(-5, TimeUnits.SECONDS).humanizeDiff() //5 дней назад
        val user3 = Date().add(24, TimeUnits.SECONDS).humanizeDiff() //через 2 минуты
        val user4 = Date().add(75, TimeUnits.SECONDS).humanizeDiff() //через 7 дней
        val user5 = Date().add(-400, TimeUnits.DAY).humanizeDiff() //более года назад
        val user6 = Date().add(2, TimeUnits.SECONDS).humanizeDiff() //более чем через год

        println(user1)
        println(user2)
        println(user3)
        println(user4)
        println(user5)
        println(user6)
    }
}
