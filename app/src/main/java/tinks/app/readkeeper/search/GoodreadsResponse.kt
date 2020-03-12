package tinks.app.readkeeper.search

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Path
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "GoodreadsResponse")
data class GoodreadsResponse(
    @Element(name = "search")
    val search: Search
)

@Xml
data class Search(
    @PropertyElement(name = "results-start")
    val resultsStart: String,
    @PropertyElement(name = "results-end")
    val resultsEnd: String,
    @PropertyElement(name = "total-results")
    val totalResults: String,
    @PropertyElement(name = "query-time-seconds")
    val queryTimeSeconds: String,
    @Path("results")
    @Element
    val results: List<Work>?
)

@Xml
data class Work(
    @PropertyElement(name = "ratings_count")
    val ratingsCount: Int,
    @PropertyElement(name = "original_publication_year")
    val originalPublicationYear: Int,
    @PropertyElement(name = "average_rating")
    val averageRating: String,
    @Element(name = "best_book")
    val book: Book
)

@Xml
data class Book(
    @PropertyElement(name = "title")
    val title: String,
    @Element(name = "author")
    val author: Author,
    @PropertyElement(name = "image_url")
    val imageUrl: String
)

@Xml
data class Author(
    @PropertyElement(name = "name")
    val name: String
)