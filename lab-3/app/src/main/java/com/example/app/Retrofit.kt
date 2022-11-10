package com.example.app


import com.example.app.items.Item
import com.example.app.items.Items
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class Retrofit {
    companion object {
        private const val baseUrl = "https://api.rss2json.com/v1/api.json/"
        private val factory = GsonConverterFactory.create()
        private val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(factory)
            .build()
        val customResponseApi = retrofit.create(CustomResponse::class.java)
    }

    interface CustomResponse {
        @GET("https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Frss.nytimes.com%2Fservices%2Fxml%2Frss%2Fnyt%2FSports.xml")
        suspend fun getUsers(): Response<Items>
    }
}