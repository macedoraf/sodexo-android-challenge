package br.com.rafael.sodexo.utill

import br.com.rafael.sodexo.data.remote.Remote
import br.com.rafael.sodexo.data.remote.TraktAPI
import br.com.rafael.sodexo.domain.interactor.GetMovieTranding
import br.com.rafael.sodexo.presentation.movies.MoviesContract
import br.com.rafael.sodexo.presentation.movies.presenter.MoviesPresenter
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injector {

    fun getMoviesPresenterInstance(): MoviesContract.Presenter =
        MoviesPresenter(getMovieTrandingInstance())

    fun getMovieTrandingInstance(): GetMovieTranding =
        GetMovieTranding(Remote(traktAPI))


    private const val BASE_URL = "https://api.trakt.tv"


    private val retrofit by lazy(LazyThreadSafetyMode.PUBLICATION) {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val gson by lazy(LazyThreadSafetyMode.PUBLICATION) { GsonBuilder().create() }

    val traktAPI by lazy(LazyThreadSafetyMode.PUBLICATION) { retrofit.create(TraktAPI::class.java) }


}