package devintensive.skillbranch.ru.devintensive.models

class Chat(
    val id:String,
    val members:MutableList<User> = mutableListOf(),
    val messages:MutableList<BaseMessage> = mutableListOf()
)