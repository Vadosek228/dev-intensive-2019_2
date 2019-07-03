package devintensive.skillbranch.ru.dev_intensive

import android.util.TimeUtils
import devintensive.skillbranch.ru.dev_intensive.extensions.TimeUnits
import devintensive.skillbranch.ru.dev_intensive.extensions.add
import devintensive.skillbranch.ru.dev_intensive.extensions.format
import devintensive.skillbranch.ru.dev_intensive.extensions.toUserView
import devintensive.skillbranch.ru.dev_intensive.models.*
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

    @Test
    fun test_instance() {
//        val user = User("1")
        val user2 = User("2", "John", "Wick")
//        val user3 = User("3", "John", "Silverhand", null, lastVisit = Date(), isOnlain = true)

//        user.printMe()
//        user2.printMe()
//        user3.printMe()

//        println("$user")
    }

    //как работает фабрика
    @Test
    fun test_factory(){
        val user = User.makeUser("John Seen")
        val user2 = User.makeUser("John Weck")
        val user3 = User.makeUser("")
        val user4 = user2.copy(id = "2", lastName = "Gav")

        print("$user2 \n$user4")
    }

    @Test
    fun test_decomposition(){
        val user = User.makeUser("John Weck")

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
            ${user2.lastVisit?.format()}
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
        val user2 = User.makeUser("Акулинин Владислав")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user2, Chat("0"), payload = "any image url", type = "image")

        println(txtMessage.formateMessage())
        println(imgMessage.formateMessage())
    }
}
