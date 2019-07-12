package devintensive.skillbranch.ru.devintensive.extensions

import devintensive.skillbranch.ru.devintensive.models.User
import devintensive.skillbranch.ru.devintensive.models.UserView
import devintensive.skillbranch.ru.devintensive.utils.Utils

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

