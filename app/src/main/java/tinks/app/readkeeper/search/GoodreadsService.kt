package tinks.app.readkeeper.search

import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface GoodreadsService {

    @GET("/search/index?key=H9ZQW1lAJm4SP8HUkhy2g")
    fun searchBookByKeyword(@Query("q") q: String): Call<GoodreadsResponse>

    companion object {
        val instance: GoodreadsService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.goodreads.com")
                .addConverterFactory(
                    TikXmlConverterFactory.create(
                        TikXml.Builder().exceptionOnUnreadXml(false).build()
                    )
                )
                .build()
            retrofit.create<GoodreadsService>(GoodreadsService::class.java)
        }
    }
}