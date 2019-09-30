package br.com.rafael.sodexo.data.remote

import br.com.rafael.sodexo.data.Repository
import br.com.rafael.sodexo.domain.model.Movie
import br.com.rafael.sodexo.utill.Either
import br.com.rafael.sodexo.utill.Failure
import retrofit2.Call

class Remote(private val traktAPI: TraktAPI) : Repository.Remote {

    override fun getMovieTrending(): Either<Failure, List<Movie>> {
        return request(
            traktAPI.getMoviesTranding(),
            {
                val list = mutableListOf<Movie>()
                it.map { response ->
                    list.add(Movie(response.movie.title))
                }
                list
            },
            emptyList()
        )
    }

    private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Either.Right(transform((response.body() ?: default)))
                false -> Either.Left(Failure.ServerError)
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError)
        }
    }

}