package br.com.rafael.sodexo.presentation.movies.presenter

import br.com.rafael.sodexo.domain.Interactor
import br.com.rafael.sodexo.domain.interactor.GetMovieTranding
import br.com.rafael.sodexo.domain.model.Movie
import br.com.rafael.sodexo.presentation.movies.MoviesContract
import br.com.rafael.sodexo.utill.Failure

class MoviesPresenter(
    private val getMovies: GetMovieTranding,
    private var view: MoviesContract.View? = null
) : MoviesContract.Presenter {
    override fun fetchMovies() {
        getMovies.invoke(Interactor.None()) { it.either(::handleFailure, ::handleSuccess) }
    }

    private fun handleFailure(failure: Failure) {
        when (failure) {
            Failure.NetworkConnection -> {
            } //TODO : Implementar exeção de conexão
            Failure.ServerError -> {
            } //TODO : Implementar exeção de server error
        }
    }

    private fun handleSuccess(list: List<Movie>) {
        val titleList = ArrayList<String>()
        list.forEach { titleList.add(it.title) }
        view?.updateMoviesList(titleList)
    }

    override fun attachView(view: MoviesContract.View) {
        this.view = view
    }


}