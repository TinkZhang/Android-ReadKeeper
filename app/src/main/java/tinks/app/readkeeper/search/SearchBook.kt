package tinks.app.readkeeper.search

data class SearchBook(
    var title: String = "",
    var author: String = "",
    var imageUrl: String = "",
    var ratingsCount: Int = 0,
    var originalPublicationYear: Int = 1900,
    var averageRating: Double = 0.0
)