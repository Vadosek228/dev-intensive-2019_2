package devintensive.skillbranch.ru.dev_intensive.models

class Chat(
    val id:String,
    val members:MutableList<User> = mutableListOf(),
    val messages:MutableList<BaseMessage> = mutableListOf()
)