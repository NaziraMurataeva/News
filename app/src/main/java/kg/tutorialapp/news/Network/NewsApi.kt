package kg.tutorialapp.news.Network

import io.reactivex.Single
import kg.tutorialapp.news.models.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String = "ru",
        @Query("category") category: String = "sports",
        @Query("apiKey") apiKey: String = "c2fd4d73742544ab9b24e3166e34645a"
    ): Single<News>
}