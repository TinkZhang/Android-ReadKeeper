package tinks.app.readkeeper.common

abstract class BasicBook {
    abstract var title: String
    open var author: String = ""
    open var imageUrl: String = ""
}