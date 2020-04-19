package tinks.app.readkeeper.search

import tinks.app.readkeeper.common.BasicBook

data class SearchBook(
    override var title: String = "",
    override var imageUrl: String = "",
    override var author: String = "",
    override var pages: Int = 0,
    override var addedTime: Long = 0,
    override var rating: Double = 0.0,
    var ratingsCount: Int = 0,
    var originalPublicationYear: Int = 1900
) : BasicBook()