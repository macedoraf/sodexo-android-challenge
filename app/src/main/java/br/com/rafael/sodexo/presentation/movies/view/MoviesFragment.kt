package br.com.rafael.sodexo.presentation.movies.view

import br.com.rafael.sodexo.R
import br.com.rafael.sodexo.presentation.CoreFragment
import br.com.rafael.sodexo.presentation.movies.MoviesContract
import br.com.rafael.sodexo.presentation.movies.view.adapter.MovieAdapter

class MoviesFragment : CoreFragment(), MoviesContract.View {

    lateinit var presenter: MoviesContract.Presenter

    private val listMovie by lazy { ArrayList<String>() }
    private val adapterMovie by lazy { MovieAdapter(listMovie) }

    override fun updateMoviesList(movies: List<String>) {
        adapterMovie.updateAll(movies)
    }

    override fun onStart() {
        super.onStart()
        presenter.fetchMovies()
    }

    override fun layoutId(): Int = R.layout.movies_fragment

    companion object {
        fun newInstance(presenter: MoviesContract.Presenter): MoviesFragment {
            val fragment = MoviesFragment()
            presenter.attachView(fragment)
            fragment.presenter = presenter
            return fragment
        }
    }
}