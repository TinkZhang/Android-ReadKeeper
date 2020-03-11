package tinks.app.readkeeper.search

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tinks.app.readkeeper.search.model.SearchResult

class SearchRepo {
    val goodreadsSerivce = GoodreadsService.instance

    fun searchByKeyword(keyword: String, callback: (SearchResult, List<SearchBook>) -> Unit) {
        val goodreadsSearchCall = goodreadsSerivce.searchBookByKeyword(keyword)
        goodreadsSearchCall.enqueue(object : Callback<GoodreadsResponse> {
            override fun onFailure(call: Call<GoodreadsResponse>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<GoodreadsResponse>,
                response: Response<GoodreadsResponse>
            ) {
                val body = response.body()
                val searchResult = SearchResult()
                val searchBooks = ArrayList<SearchBook>()
                body?.search?.let {
                    searchResult.totolResults = it.totalResults.toInt()
                    searchResult.queryTimeSeconds = it.queryTimeSeconds.toDouble()
                }

                val results = body?.search?.results
                results?.let {
                    for (result in results) {
                        searchBooks.add(
                            SearchBook(
                                title = result.book.title,
                                imageUrl = result.book.imageUrl,
                                originalPublicationYear = result.originalPublicationYear,
                                ratingsCount = result.ratingsCount,
                                averageRating = result.averageRating.toDouble(),
                                author = result.book.author.name
                            )
                        )
                    }
                }
                callback(searchResult, searchBooks)
            }

        })
    }


}