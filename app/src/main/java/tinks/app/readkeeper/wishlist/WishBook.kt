package tinks.app.readkeeper.wishlist

import tinks.app.readkeeper.common.BasicBook
import java.util.*

data class WishBook(
    var addDate: Date = Date(),
    override var title: String
) : BasicBook()