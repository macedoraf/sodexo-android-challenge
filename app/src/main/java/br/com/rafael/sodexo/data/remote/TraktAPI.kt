package br.com.rafael.sodexo.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface TraktAPI {

    companion object{
        const val API_KEY = "trakt-api-key: 780be90f854635f1420843494e2d7debed32758b577aadfbc7a0cd1d3af9d4fb"
        const val API_VERSION = "trakt-api-version: 2"
        const val AUTORIZATION_BARRER_TOKEN = "Authorization"
    }

    @Headers(
        API_KEY,
        API_VERSION,
        AUTORIZATION_BARRER_TOKEN
    )

    @GET(value = "movies/trending")
    fun getMoviesTranding(): Call<List<MoviesTrendingResponse>>
}