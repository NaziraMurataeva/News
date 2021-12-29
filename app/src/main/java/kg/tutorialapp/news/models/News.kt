package kg.tutorialapp.news.models

import androidx.room.Entity

@Entity
data class News(

    var status : String ,
    var  totalResults: Int,
    var articles: List<Articles>,
)

data class Articles(
    var source: Source,
    var author:String,
    var title: String,
    var description: String,
    var url:String,
    var urlToImage:String,
    var publishedAt: String,
    var content: String
)

class Source(
    val id: String,
    var name: String,
)


