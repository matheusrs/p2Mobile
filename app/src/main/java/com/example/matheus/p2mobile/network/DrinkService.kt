package com.example.matheus.p2mobile.network

import com.example.matheus.p2mobile.entities.Drink
import com.example.matheus.p2mobile.entities.DrinkList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkService {

    companion object {
        private const val API_KEY = "apiKey=1"
    }

    @GET("random.php?$API_KEY")
    fun getRandom(): Call<Drink>

    @GET("search.php?$API_KEY")
    fun searchDrink(@Query("q") query: String): Call<DrinkList>



}