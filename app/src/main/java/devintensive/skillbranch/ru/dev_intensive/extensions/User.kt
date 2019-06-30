package devintensive.skillbranch.ru.dev_intensive.extensions

import devintensive.skillbranch.ru.dev_intensive.models.User
import devintensive.skillbranch.ru.dev_intensive.models.UserView
import devintensive.skillbranch.ru.dev_intensive.utils.Utils
import java.util.*

fun User.toUserView() : UserView{
    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if(lastVisit == null) "Еще ни разу не был" else if (isOnlain) "online" else "Последний раз был в сети " +
            "${lastVisit.humanizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickName,
        initials = initials,
        status = status )
}

