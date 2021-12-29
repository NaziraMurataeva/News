package kg.tutorialapp.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kg.tutorialapp.news.Network.NewsClient
import kg.tutorialapp.news.databinding.ActivityMainBinding
import kg.tutorialapp.news.models.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //getNews()
    }


    private fun getNews() {
        val call = NewsClient.NewsApi.getNews(country = "ru", category = "sports")

        call.enqueue ( object : Callback<News> {

            override fun onResponse(call: Call<News>, response: Response<News>) {
                if (response.isSuccessful) {
                    val news = response.body()
                    news?.let {
                        {
                            binding.text1.text = it.status
                        }
                    }
                 }
                }

            override fun onFailure(call: Call<News>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}
