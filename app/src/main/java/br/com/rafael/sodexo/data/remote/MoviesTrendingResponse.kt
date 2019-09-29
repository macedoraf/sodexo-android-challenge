package br.com.rafael.sodexo.data.remote

data class MoviesTrendingResponse(
    val movie: Movie,
    val watchers: Int
) {

    data class Movie(
        val ids: Ids,
        val title: String,
        val year: Int
    )

    data class Ids(
        val imdb: String,
        val slug: String,
        val tmdb: Int,
        val trakt: Int
    )

}