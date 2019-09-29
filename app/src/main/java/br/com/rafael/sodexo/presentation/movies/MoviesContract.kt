package br.com.rafael.sodexo.presentation.movies

interface MoviesContract {

    interface View {
        fun updateMoviesList(movies: List<String>)
    }

    interface Presenter {
        fun attachView(view: View)
        fun fetchMovies()
    }
}