package tinks.app.readkeeper.search

import tinks.app.readkeeper.common.BasicBook

data class SearchBook(
    override var title: String = "",
    override var author: String = "",
    override var imageUrl: String = "",
    var ratingsCount: Int = 0,
    var originalPublicationYear: Int = 1900,
    var averageRating: Double = 0.0
) : BasicBook()