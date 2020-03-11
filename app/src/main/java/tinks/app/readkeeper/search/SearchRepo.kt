package tinks.app.readkeeper.search

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRepo {
    val goodreadsSerivce = GoodreadsService.instance

    fun searchByKeyword(keyword: String, callback: (String) -> Unit) {
        val goodreadsSearchCall = goodreadsSerivce.searchBookByKeyword(keyword)
        goodreadsSearchCall.enqueue(object : Callback<GoodreadsResponse> {
            override fun onFailure(call: Call<GoodreadsResponse>, t: Throwable) {
                callback(t.message.toString())
            }

            override fun onResponse(
                call: Call<GoodreadsResponse>,
                response: Response<GoodreadsResponse>
            ) {
                val body = response.body()
                callback("Find ${body?.search?.totalResults}")
            }

        })
    }


}